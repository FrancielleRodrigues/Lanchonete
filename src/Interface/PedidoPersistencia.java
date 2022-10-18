/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Pedido;

/**
 *
 * @author sala306b
 */
public interface PedidoPersistencia {
    
    public void cadastra(Pedido pedido) throws SQLException;
    public void exclui(Pedido pedido) throws SQLException;
    public void editar(int idCPedido,Pedido pedido) throws SQLException;
    public Pedido pesquisa(Object o) throws SQLException;
    public ArrayList<Pedido> listPedido() throws SQLException;
}
