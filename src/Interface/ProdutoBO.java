/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.ArrayList;
import modelo.Cliente;
import modelo.Produto;

/**
 *
 * @author sala306b
 */
public interface ProdutoBO {
    
    public void cadastraProduto(Produto produto) throws Exception;
    public void excluiCliente(Produto produto) throws Exception;
    public void editarProduto(int idProduto,Produto produto) throws Exception;
    public Produto pesquisaProduto(String descricaoProduto) throws Exception;
    public ArrayList<Produto> listProduto() throws Exception;
}
