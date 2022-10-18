/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.ArrayList;
import modelo.Pedido;

/**
 *
 * @author sala306b
 */
public interface PedidoBO {
    
    public void cadastraPedido(Pedido pedido) throws Exception;
    public void excluiPedido(Pedido pedido) throws Exception;
    public void editarPedido(int idPedido,Pedido pedido) throws Exception;
    public void calculo()throws Exception;
    public Pedido pesquisaPedido(int idPedido) throws Exception;
    public ArrayList<Pedido> listPedido() throws Exception;
}
