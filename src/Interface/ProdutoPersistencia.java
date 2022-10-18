/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Produto;


/**
 *
 * @author sala306b
 */
public interface ProdutoPersistencia {
    public void cadastra(Produto produto) throws SQLException;
    public void exclui(Produto produto) throws SQLException;
    public void editar( Produto produto) throws SQLException;
    public Produto pesquisa(String descricao) throws SQLException;
    public ArrayList<Produto> listProduto() throws SQLException;
    public ArrayList<Produto> listProduto(String descricao) throws SQLException;
}
