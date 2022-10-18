/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.ProdutoDAO;
import java.sql.SQLException;

/**
 *
 * @author sala306b
 */
public class Produto {
    private int idProduto;
    private String descricaoProduto;
    private double valor;
    
     public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
//    public void cadastrar() throws SQLException{
//        ProdutoDAO pdao = new ProdutoDAO();
//        pdao.cadastra(this);
//    }
    
}
