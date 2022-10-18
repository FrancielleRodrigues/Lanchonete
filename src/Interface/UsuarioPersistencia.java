/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Usuario;


/**
 *
 * @author sala306b
 */
public interface UsuarioPersistencia {
    
    public void cadastra(Usuario usuario) throws SQLException;
    public void exclui(Usuario usuario) throws SQLException;
    public void editar(int idProduto,Usuario usuario) throws SQLException;
    public ArrayList<Usuario> listUsuario() throws SQLException;
}
