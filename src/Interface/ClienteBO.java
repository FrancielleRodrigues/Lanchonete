/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.ArrayList;
import modelo.Cliente;

/**
 *
 * @author sala306b
 */
public interface ClienteBO {
    
    public void cadastraCliente(Cliente cliente) throws Exception;
    public void excluiCliente(Cliente cliente) throws Exception;
    public void editarCliente(Cliente cliente) throws Exception;
    public Cliente pesquisaCliente(int telefone) throws Exception;
    public Cliente pesquisaCliente(String nome) throws Exception;
    public ArrayList<Cliente> listCliente() throws Exception;
    public ArrayList<Cliente> listCliente(String nome) throws Exception;
    
        
    
    
}
