/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Interface.PedidoPersistencia;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Elzi
 */
public class ManipulaPedido  implements  PedidoPersistencia{

    @Override
    public void cadastra(Pedido pedido) throws SQLException {
      
    }

    @Override
    public void exclui(Pedido pedido) throws SQLException {
        //vamos fazer controler
    }

    @Override
    public void editar(int idCPedido, Pedido pedido) throws SQLException {
        //vamos fazer controler
    }

    @Override
    public Pedido pesquisa(Object o) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Pedido> listPedido() throws SQLException {
        return null;
    }
    
}
