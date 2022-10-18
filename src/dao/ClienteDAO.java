/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Interface.ClientePersistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import modelo.Cliente;
import visao.FrameCadastroCliente;

/**
 *
 * @author sala306b
 */
public class ClienteDAO implements ClientePersistencia {

    FrameCadastroCliente fcad = new FrameCadastroCliente();

    @Override
    public void cadastra(Cliente cliente) throws SQLException {
        BDMySQL bd = new BDMySQL();
        String query = "INSERT INTO cliente( "
                + "idCliente,"
                + "nome,"
                + "telefone,"
                + "data_nascimento,"
                + "logradouro,"
                + "numero,"
                + "bairro,"
                + "cidade,"
                + "complemento,"
                + "ponto_referencia)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement statement = bd.getConnection().prepareStatement(query);

        statement.setInt(1, cliente.getIdCliente());
        statement.setString(2, cliente.getNome());
        statement.setString(3, cliente.getTelefone());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        statement.setString(4, sdf.format(cliente.getDataNascimento()));

        statement.setString(5, cliente.getLogradouro());
        statement.setInt(6, cliente.getNumeroCasa());
        statement.setString(7, cliente.getBairro());
        statement.setString(8, cliente.getCidade());
        statement.setString(9, cliente.getComplemento());
        statement.setString(10, cliente.getPontoRef());

        int result = statement.executeUpdate();

        statement.close();
        bd.fechaConexao();

        if (result == 0) {
            throw new SQLException("Nenhum cliente cadastrado");
        }

    }

    @Override
    public void editar(Cliente cliente) throws SQLException {
        BDMySQL bd = new BDMySQL();
        String query = "update cliente set "
                + "nome=?,"
                + "telefone=?,"
                + "data_nascimento=?,"
                + "logradouro=?,"
                + "numero=?,"
                + "bairro=?,"
                + "cidade=?,"
                + "complemento=?,"
                + "ponto_referencia=?"
                + " where idCliente = ?";
        PreparedStatement statement = bd.getConnection().prepareStatement(query);

        statement.setString(1, cliente.getNome());
        statement.setString(2, cliente.getTelefone());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       
        statement.setString(3, sdf.format(cliente.getDataNascimento()));

        statement.setString(4, cliente.getLogradouro());
        statement.setInt(5, cliente.getNumeroCasa());
        statement.setString(6, cliente.getBairro());
        statement.setString(7, cliente.getCidade());
        statement.setString(8, cliente.getComplemento());
        statement.setString(9, cliente.getPontoRef());
        statement.setInt(10, cliente.getIdCliente());

        int result = statement.executeUpdate();

        statement.close();
        bd.fechaConexao();

        if (result == 0) {
            throw new SQLException("A conta não foi atualizada");
        }
    }

    @Override
    public Cliente pesquisa(String nomeDoCampo, Object valorDoCampo) throws SQLException {

        BDMySQL bd = new BDMySQL();
        String query = "select * from cliente where " + nomeDoCampo + " = ?";
        PreparedStatement statement = bd.getConnection().prepareStatement(query);
        statement.setObject(1, valorDoCampo);
        ResultSet resultSet = statement.executeQuery();

        Cliente cli = new Cliente();

        if (resultSet.next()) {
            int idCliente = resultSet.getInt("idCliente");
            String nome = resultSet.getString("nome");
            String telefone = resultSet.getString("telefone");
            Date dataN = resultSet.getDate("data_nascimento");
            String logra = resultSet.getString("logradouro");
            int num = resultSet.getInt("numero");
            String bairro = resultSet.getString("bairro");
            String cidade = resultSet.getString("cidade");
            String comple = resultSet.getString("complemento");
            String pdr = resultSet.getString("ponto_referencia");

            cli.setNome(nome);
            cli.setTelefone(telefone);
            cli.setDataNascimento(dataN);
            cli.setLogradouro(logra);
            cli.setNumeroCasa(num);
            cli.setBairro(bairro);
            cli.setCidade(cidade);
            cli.setComplemento(comple);
            cli.setPontoRef(pdr);

        } else {
            throw new SQLException("Essa conta não foi encontrada "
                    + "no Banco de Dados");
        }

        return cli;
    }

    @Override
    public ArrayList<Cliente> listCliente() throws SQLException {
        ArrayList<Cliente> cliente = null;
        BDMySQL bd = new BDMySQL();
        String query = "Select * from cliente";
        PreparedStatement statement = bd.getConnection().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        cliente = new ArrayList<>();

        Cliente cli ;
        while (resultSet.next()) {
            cli = new Cliente();
            cli.setIdCliente(resultSet.getInt("idCliente"));
            cli.setNome(resultSet.getString("nome"));
            cli.setTelefone(resultSet.getString("telefone"));
        
            cli.setDataNascimento(resultSet.getDate("data_nascimento"));      
            
            cli.setLogradouro(resultSet.getString("logradouro"));
            cli.setNumeroCasa(resultSet.getInt("numero"));
            cli.setBairro(resultSet.getString("bairro"));
            cli.setCidade(resultSet.getString("cidade"));
            cli.setComplemento(resultSet.getString("complemento"));
            cli.setPontoRef(resultSet.getString("ponto_referencia"));

            cliente.add(cli);
        }

        if (cliente.isEmpty()) {
            throw new SQLException("A lista de Clientes está vazia");
        }

        return cliente;

    }

    @Override
    public ArrayList<Cliente> pesquisa(String nomeCli) throws SQLException {

        ArrayList<Cliente> listaClientes = new ArrayList<>();

        BDMySQL bd = new BDMySQL();
        String query = "select * from cliente where nome LIKE ?";
        PreparedStatement statement = bd.getConnection().prepareStatement(query);
        statement.setObject(1, nomeCli + "%");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int idCliente = resultSet.getInt("idCliente");
            String nome = resultSet.getString("nome");
            String telefone = resultSet.getString("telefone");
            Date dataN = resultSet.getDate("data_nascimento");
            String logra = resultSet.getString("logradouro");
            int num = resultSet.getInt("numero");
            String bairro = resultSet.getString("bairro");
            String cidade = resultSet.getString("cidade");
            String comple = resultSet.getString("complemento");
            String pdr = resultSet.getString("ponto_referencia");

            Cliente cli = new Cliente();
            cli.setIdCliente(idCliente);
            cli.setNome(nome);
            cli.setTelefone(telefone);
            cli.setDataNascimento(dataN);
            cli.setLogradouro(logra);
            cli.setNumeroCasa(num);
            cli.setBairro(bairro);
            cli.setCidade(cidade);
            cli.setComplemento(comple);
            cli.setPontoRef(pdr);

            listaClientes.add(cli);

        }

        if (listaClientes.size() == 0) {
            throw new SQLException("Não foram encontrados clientes com essa pesquisa");
        }

        return listaClientes;
    }

    @Override
    public void exclui(Cliente cliente) throws SQLException {

        BDMySQL bd = new BDMySQL();
        String query = "delete from cliente where idCliente = ?";

        PreparedStatement statement = bd.getConnection().prepareStatement(query);
        statement.setInt(1, cliente.getIdCliente());

        int result = statement.executeUpdate();
        statement.close();
        bd.fechaConexao();

        if (result == 0) {
            throw new SQLException("A conta não foi encontrada "
                    + "ou já foi excluída");
        }
    }
}
