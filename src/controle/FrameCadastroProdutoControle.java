/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.awt.event.ActionEvent;
import visao.FrameCadastroProduto;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ManipulaProduto;
import modelo.Produto;

import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import visao.FramePrincipal;

/**
 *
 * @author sala306b
 */
public class FrameCadastroProdutoControle implements ActionListener, MouseListener {

    public FrameCadastroProduto fcp;
    ManipulaProduto mp = new ManipulaProduto();
    Produto produto = null;
    ArrayList<Produto> listPro = null;
    public FramePrincipal fp;

    public FrameCadastroProdutoControle(FrameCadastroProduto fcp) {
        this.fcp = fcp;

        this.fcp.getBtSalvarProduto().addActionListener(this);
        this.fcp.getBtPesquisar().addActionListener(this);
        this.fcp.getBtExcluirProduto().addActionListener(this);
        this.fcp.getBtAtualizar().addActionListener(this);

        this.fcp.getTabelaProduto().addMouseListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fcp.getBtSalvarProduto()) {

            try {
                Produto p = new Produto();
                p.setDescricaoProduto(fcp.getCtDescricaoPro().getText());
                p.setValor(Double.parseDouble(fcp.getCtValorPro().getText()));

               

                mp.cadastra(p);

                JOptionPane.showMessageDialog(fcp, "Produto cadastrado com sucesso!");
                 fcp.getBtAtualizar().setEnabled(true);
                fcp.getCtDescricaoPro().setText("");
                fcp.getCtValorPro().setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(fcp, "UM erro não identificado foi encontrado. Volte e tente novamente");
                ex.printStackTrace();
            }

        }
        if (e.getSource() == fcp.getBtPesquisar()) {
            String descricao = fcp.getCtDescricaoPPesquisa().getText();
            try {
                listPro = mp.listProduto(descricao);
                DefaultTableModel tableModel = (DefaultTableModel) fcp.getTabelaProduto().getModel();
                 tableModel.setNumRows(0);
                 
                 for (Produto p : listPro) {

                        Object[] linha = {
                            p.getDescricaoProduto(),
                            p.getValor()};

                        tableModel.addRow(linha);

                    }
                    fcp.getCtDescricaoPPesquisa().requestFocus();
                    fcp.getCtDescricaoPPesquisa().selectAll();
                    

                   

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Este Produto não foi encontrado");
                }
                
            


        }
        if (e.getSource() == fcp.getBtExcluirProduto()) {
            
            if (fcp.getTabelaProduto().getSelectedRowCount() != 1) {
                JOptionPane.showMessageDialog(null, "Selecione apenas uma linha ");
            } else {

                try {

                    mp.exclui(produto);;
                    JOptionPane.showMessageDialog(fp, "Produto excluido com sucesso");
                    atualizaTabela();
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "<html>"
                            + "<font color=blue size=4><b>"
                            + "" + ex.getMessage() + ""
                            + "</b></font>"
                            + "</html>",
                            "Buscando Conta", JOptionPane.WARNING_MESSAGE);
                    ex.printStackTrace();
                }

            }

        }
        if (e.getSource() == fcp.getBtAtualizar()) {
            
        try {
                
              produto.setDescricaoProduto(fcp.getCtDescricaoPro().getText());
              produto.setValor(Double.parseDouble(fcp.getCtValorPro().getText()));
              
              
               mp.editar(produto);
                JOptionPane.showMessageDialog(fp, "Cliente Atualizado com sucesso");
                 fcp.getCtDescricaoPro().setText("");
                 fcp.getCtValorPro().setText("");
                
                atualizaTabela();
                
                fcp.getBtSalvarProduto().setEnabled(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(fp, "Erro ao Atualizar tabela" );
                ex.printStackTrace();
            }
           
        }
            
            
        }


    

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == fcp.getTabelaProduto()) {

            if (e.getClickCount() == 1) {

                if (fcp.getTabelaProduto().getSelectedRowCount() == 1) {

                    int linha = fcp.getTabelaProduto().getSelectedRow();
                    produto = listPro.get(linha);

                }
            }else if (e.getClickCount() == 2) {
                    
                 int resp = JOptionPane.showConfirmDialog(fcp,
                            "Tem certeza que deseja ALTERAR essa conta?",
                            "ALTERAR CONTA", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (resp == JOptionPane.YES_OPTION) {
                        
            
                
                 fcp.getBtAtualizar().setEnabled(true); 
                 fcp.getBtSalvarProduto().setEnabled(false);
                
                 int linha = fcp.getTabelaProduto().getSelectedRow();
                 produto = listPro.get(linha);
                 try {
                 fcp.getCtDescricaoPro().setText(produto.getDescricaoProduto());
                 fcp.getCtValorPro().setText(String.valueOf(produto.getValor()));
                
                    
                } catch (Exception ex) {
                    Logger.getLogger(FrameCadastroClienteControle.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
                    }
                
            }

        }
            }
        
    
    
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
     public void atualizaTabela() {
        try {
            listPro = mp.listProduto();
            DefaultTableModel tableModel = (DefaultTableModel) fcp.getTabelaProduto().getModel();
            tableModel.setNumRows(0);

            for (Produto p : listPro) {

                Object[] linha = {
                    
                    p.getDescricaoProduto(),
                    p.getValor()};

                tableModel.addRow(linha);

            }
             fcp.getCtDescricaoPPesquisa().requestFocus();
                    fcp.getCtDescricaoPPesquisa().selectAll();
           

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Nenhum produto encontrado");
        }
    }

}
