/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Interface.ProdutoPersistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.Produto;

/**
 *
 * @author sala306b
 */
public class ProdutoDAO  implements ProdutoPersistencia{

    @Override
    public void cadastra(Produto produto) throws SQLException {
        
        BDMySQL bd = new BDMySQL();
        String query = "INSERT INTO produto( "
                + "idProduto,"
                + "descricao_produto,"
                + "valor)"
                + "VALUES (?,?,?)";
        
        
        PreparedStatement statement = bd.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        statement.setInt(1, produto.getIdProduto());
        statement.setString(2, produto.getDescricaoProduto());
        statement.setDouble(3, produto.getValor());
      
        
        
        int result = statement.executeUpdate();
        
        statement.close();
        bd.fechaConexao();
        
        if(result == 0){
            throw new SQLException("Nenhum produto cadastrado");
        }
        
    }

    @Override
    public void exclui(Produto produto) throws SQLException {
         BDMySQL bd = new BDMySQL();
        String query = "delete from produto where idProduto = ? ";
        PreparedStatement statement = bd.getConnection().prepareStatement(query);
        statement.setInt(1, produto.getIdProduto());
        int result = statement.executeUpdate();
        statement.close();
        bd.fechaConexao();

        if (result == 0) {
            throw new SQLException("O produto não foi encontrada "
                    + "ou já foi excluído");
        }
    }
    

    @Override
    public void editar( Produto produto) throws SQLException {
 BDMySQL bd = new BDMySQL();
        String query = "update produto set "
                + "descricao_produto=?,"
                + "valor=?"
                +"where idProduto=?";
                
        PreparedStatement statement = bd.getConnection().prepareStatement(query);
        
        statement.setString(1, produto.getDescricaoProduto());
        statement.setDouble(2, produto.getValor());
        statement.setInt(3, produto.getIdProduto());
       
         
        int result = statement.executeUpdate();

        statement.close();
        bd.fechaConexao();

        if (result == 0) {
            throw new SQLException("O produto não foi atualizado");
        }
    }

   
         
        
    

    @Override
    public Produto pesquisa(String descricaoPro) throws SQLException {
  
        
        BDMySQL bd = new BDMySQL();
        
        String query = "select * from produto where ? = ?";
        PreparedStatement statement = bd.getConnection().prepareStatement(query);
        statement.setObject(1, descricaoPro );
        ResultSet resultSet = statement.executeQuery();
        
        

            Produto p = new Produto();
        
         if(resultSet.next()) {
            int idProduto = resultSet.getInt("idProduto");
            String descricaoP = resultSet.getString("descricao_produto");
            Double valor = resultSet.getDouble("valor");
            
    
            
            p.setIdProduto(idProduto);
            p.setDescricaoProduto(descricaoP);
            p.setValor(valor);
          
            
        }   else {
            throw new SQLException("Esse produto não foi encontrado "
                    + "no Banco de Dados");
        }

        return p; 
       
    }

    @Override
    public ArrayList<Produto> listProduto() throws SQLException {
           ArrayList<Produto> produto = null;
        BDMySQL bd = new BDMySQL();
        String query = "Select * from produto";
        PreparedStatement statement = bd.getConnection().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        produto = new ArrayList<>();
        
        Produto p ;
        while(resultSet.next()){
            p = new Produto();
            p.setIdProduto(resultSet.getInt("idProduto"));
            p.setDescricaoProduto(resultSet.getString("descricao_produto"));
            p.setValor(resultSet.getDouble("valor"));
        
            
            produto.add(p);
        }
        
        if(produto.isEmpty()){
            throw new SQLException("A lista de PRODUTOS está vazia"); 
        }
        
        
        
        return produto;
    }

    @Override
    public ArrayList<Produto> listProduto(String descricaoPro) throws SQLException {
          ArrayList<Produto> listaProdutos = new ArrayList<>();
        
        BDMySQL bd = new BDMySQL();
        
        String query = "select * from produto where  descricao_produto LIKE ?";
        PreparedStatement statement = bd.getConnection().prepareStatement(query);
        statement.setObject(1, descricaoPro + "%" );
        
        ResultSet resultSet = statement.executeQuery();

        
       while (resultSet.next()) {
            int idProduto = resultSet.getInt("idProduto");
            String descricaoP = resultSet.getString("descricao_produto");
            Double valor = resultSet.getDouble("valor");
            
    
            
            Produto p = new Produto();
            p.setIdProduto(idProduto);
            p.setDescricaoProduto(descricaoP);
            p.setValor(valor);
            
            listaProdutos.add(p);
          
            
        }  if (listaProdutos.size() == 0) {
            throw new SQLException("Não foram encontrados produtos com essa pesquisa");
        }

        return listaProdutos; 
    }
       
    }
