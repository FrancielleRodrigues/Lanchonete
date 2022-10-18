/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Interface.UsuarioPersistencia;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sala306b
 */
public class ManipulaUsuario implements UsuarioPersistencia{

    @Override
    public void cadastra(Usuario usuario) throws SQLException {
        if(usuario.equals("")){
            try {
                throw new Exception("O NOME de usuário é obrigatório");
            } catch (Exception ex) {
               JOptionPane.showMessageDialog(null, "Conta não Cadastrada");
            }
        }
        UsuarioDAO udao = new UsuarioDAO();
        udao.cadastra(usuario);
        
    }

    @Override
    public void exclui(Usuario usuario) throws SQLException {
        // fazer na controler
    }

    @Override
    public void editar(int idProduto, Usuario usuario) throws SQLException {
        // fazer na controler
    }

    
    @Override
    public ArrayList<Usuario> listUsuario() throws SQLException {
        UsuarioDAO udao = new UsuarioDAO();
        return udao.listUsuario();
        
    }
    
}
