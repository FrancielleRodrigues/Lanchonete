/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.ArrayList;
import modelo.Cliente;
import java.sql.SQLException;
/**
 *
 * @author sala306b
 */
public interface ClientePersistencia {
    
    public void cadastra(Cliente cliente) throws SQLException;
    public void exclui(Cliente cliente) throws SQLException;
    public void editar(Cliente cliente) throws SQLException;
    public Cliente pesquisa(String string,Object o) throws SQLException;
    public ArrayList<Cliente> pesquisa(String  nome) throws SQLException;
    public ArrayList<Cliente> listCliente() throws SQLException;
    
    
    
}
