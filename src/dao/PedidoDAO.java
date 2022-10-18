/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Interface.PedidoPersistencia;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.Pedido;

/**
 *
 * @author sala306b
 */
public class PedidoDAO implements PedidoPersistencia{

    @Override
    public void cadastra(Pedido pedido) throws SQLException {
   BDMySQL bd = new BDMySQL();
        String query = "INSERT INTO pedido( "
                + "idPedido,"
                + "quantidade,"
                + "observacoes,"
                + "data_pedido,"
                + "total,"
                + "quanti_receber,"
                + "troco)"
                + "VALUES (?,?,?,?,?,?,?)";
        
        
        java.sql.PreparedStatement statement = bd.getConnection().prepareStatement(query, java.sql.PreparedStatement.RETURN_GENERATED_KEYS);
        statement.setInt(1, pedido.getIdPedido());
        statement.setInt(2, pedido.getQuantidade());
        statement.setString(3, pedido.getObservacoes());
        statement.setString(4, pedido.getDataPedido());
        statement.setDouble(5, pedido.getTotal());
        statement.setDouble(6, pedido.getQuantiaReceber());
        statement.setDouble(7, pedido.getTroco());
        
        
        
        int result = statement.executeUpdate();
        
        statement.close();
        bd.fechaConexao();
        
        if(result == 0){
            throw new SQLException("Nenhum pedido cadastrado");
        }
        
    }

    @Override
    public void exclui(Pedido pedido) throws SQLException {
      BDMySQL bd = new BDMySQL();
        String query = "delete from pedido where idPedido = ? ";
        
       java.sql.PreparedStatement statement = bd.getConnection().prepareStatement(query);
        
        statement.setInt(1, pedido.getIdPedido());
        statement.setInt(2, pedido.getQuantidade());
        statement.setString(3, pedido.getObservacoes());
        statement.setString(4, pedido.getDataPedido());
        statement.setDouble(5, pedido.getTotal());
        statement.setDouble(6, pedido.getQuantiaReceber());
        statement.setDouble(7, pedido.getTroco());
        
        
        
        int result = statement.executeUpdate();
        statement.close();
        bd.fechaConexao();

        if (result == 0) {
            throw new SQLException("A conta não foi encontrada "
                    + "ou já foi excluída");
        }
    }

    @Override
    public void editar(int idPedido, Pedido pedido) throws SQLException {
     BDMySQL bd = new BDMySQL();
        String query = "update pedido set "
                + "idPedido=?"
                + "quantidade=?"
                + "observacoes=?"
                + "data_pedido=?"
                + "total=?"
                + "quanti_receber=?"
                + "troco=?"
                + " where idPedido = ? ";
        
        
        java.sql.PreparedStatement statement = bd.getConnection().prepareStatement(query);
        
       statement.setInt(1, pedido.getIdPedido());
        statement.setInt(2, pedido.getQuantidade());
        statement.setString(3, pedido.getObservacoes());
        statement.setString(4, pedido.getDataPedido());
        statement.setDouble(5, pedido.getTotal());
        statement.setDouble(6, pedido.getQuantiaReceber());
        statement.setDouble(7, pedido.getTroco());
         
        int result = statement.executeUpdate();

        statement.close();
        bd.fechaConexao();

        if (result == 0) {
            throw new SQLException("A conta não foi atualizada");
        }
    }

    @Override
    public Pedido pesquisa(Object o) throws SQLException {
        return null;

    }

    @Override
    public ArrayList<Pedido> listPedido() throws SQLException {
        
        ArrayList<Pedido> pedidos = null;
        BDMySQL bd = new BDMySQL();
        String query = "Select * from pedido";
        java.sql.PreparedStatement statement = bd.getConnection().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        
        pedidos = new ArrayList<>();
        
        Pedido pe = new Pedido();
        while(resultSet.next()){
                     
            pe.setIdPedido(resultSet.getInt("idPedido"));
            pe.setQuantidade(resultSet.getInt("quantidade"));
            pe.setObservacoes(resultSet.getString("observacoes"));
            pe.setDataPedido(resultSet.getString("data_pedido"));
            pe.setQuantiaReceber(resultSet.getDouble("quantia_receber"));
            pe.setTotal(resultSet.getDouble("total"));
            pe.setTroco(resultSet.getDouble("troco"));
            
            pedidos.add(pe);
        }
        
        if(pedidos.isEmpty()){
            throw new SQLException("A lista de Pedidos está vazia"); 
        }
        
        
        
        return pedidos;
        
    }
    }
    

