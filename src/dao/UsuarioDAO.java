/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Interface.UsuarioPersistencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Produto;
import modelo.Usuario;

/**
 *
 * @author sala306b
 */
public class UsuarioDAO implements UsuarioPersistencia{

    @Override
    public void cadastra(Usuario usuario) throws SQLException {
         BDMySQL bd = new BDMySQL();
        String query = "INSERT INTO usuario( "
                + "idUsuario,"
                + "login,"
                + "senha)"
                + "VALUES (?,?,?)";
        
        
        PreparedStatement statement = bd.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        statement.setInt(1, usuario.getIdUsuario());
        statement.setString(2, usuario.getLogin());
        statement.setString(3, usuario.getSenha());
      
        
        
        int result = statement.executeUpdate();
        
        statement.close();
        bd.fechaConexao();
        
        if(result == 0){
            throw new SQLException("Nenhum usuario cadastrado");
        }
    }

    @Override
    public void exclui(Usuario usuario) throws SQLException {
        
         BDMySQL bd = new BDMySQL();
        String query = "delete from usuario where idUsuario = ? ";
        PreparedStatement statement = bd.getConnection().prepareStatement(query);
        statement.setInt(1, usuario.getIdUsuario());
        int result = statement.executeUpdate();
        statement.close();
        bd.fechaConexao();

        if (result == 0) {
            throw new SQLException("O usuario não foi encontrado "
                    + "ou já foi excluído");
        }
    }

    @Override
    public void editar(int idProduto, Usuario usuario) throws SQLException {
        BDMySQL bd = new BDMySQL();
        String query = "update usuario set "
                + "idUsuario=?"
                + "login=?"
                + "senha=?";
        PreparedStatement statement = bd.getConnection().prepareStatement(query);
        statement.setInt(1, usuario.getIdUsuario());
        statement.setString(2, usuario.getLogin());
        statement.setString(3, usuario.getSenha());
       
         
        int result = statement.executeUpdate();

        statement.close();
        bd.fechaConexao();

        if (result == 0) {
            throw new SQLException("O usuario não foi atualizado");
        }
    }

    
    @Override
    public ArrayList<Usuario> listUsuario() throws SQLException {
         ArrayList<Usuario> usuario = null;
        BDMySQL bd = new BDMySQL();
        String query = "Select * from  usuario";
        PreparedStatement statement = bd.getConnection().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        usuario = new ArrayList<>();
        
        Usuario u = new Usuario();
        while(resultSet.next()){
                     
            u.setIdUsuario(resultSet.getInt("idUsuario"));
            u.setLogin(resultSet.getString("login"));
            u.setSenha(resultSet.getString("senha"));
        
            
            usuario.add(u);
        }
        
        if(usuario.isEmpty()){
            throw new SQLException("A lista de USUÁRIOS está vazia"); 
        }
        
        
        
        return usuario;
    }
       
    }
    

