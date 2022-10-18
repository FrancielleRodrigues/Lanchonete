/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Interface.ProdutoPersistencia;
import dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elzi
 */
public class ManipulaProduto implements ProdutoPersistencia{

    
    ProdutoDAO pdao = new ProdutoDAO();
    @Override
    public void cadastra(Produto produto) throws SQLException {
        if(produto.getDescricaoProduto().equals("")){
            try {
                throw new Exception("A DESCRIÇÃO do prodruto é obrigatória");
            } catch (Exception ex) {
                Logger.getLogger(ManipulaProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(produto.getValor() == 0){
            try {
                throw new Exception("O VALOR do prodruto é obrigatório");
            } catch (Exception ex) {
                Logger.getLogger(ManipulaProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        pdao.cadastra(produto);
        
    }

    @Override
    public void exclui(Produto produto) throws SQLException {
        pdao.exclui(produto);
    }



    public Produto pesquisa(String descricao) throws SQLException {
        
        if(descricao.equals("")){
            try {
                throw new Exception("A DESCRIÇÃO do prodruto é obrigatória");
            } catch (Exception ex) {
                Logger.getLogger(ManipulaProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
         
            
    }
         
           return pdao.pesquisa(descricao);
    
    }
    
    @Override
    public ArrayList<Produto> listProduto() throws SQLException {
      
       return pdao.listProduto();
    }

    @Override
    public ArrayList<Produto> listProduto(String descricao) throws SQLException {
        
       return pdao.listProduto(descricao);
    }

    @Override
    public void editar(Produto produto) throws SQLException {
        pdao.editar(produto);
    }

  
    
}
