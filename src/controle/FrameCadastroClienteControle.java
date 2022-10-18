/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.ManipulaCliente;
import visao.FrameCadastroCliente;
import visao.FramePrincipal;

/**
 *
 * @author sala306b
 */
public class FrameCadastroClienteControle implements ActionListener, MouseListener {

    public FrameCadastroCliente fcc;
    public FramePrincipal fp;
    Cliente cliente = null;
    ManipulaCliente mc = new ManipulaCliente();
    ArrayList<Cliente> listCli = null;

    public FrameCadastroClienteControle(FrameCadastroCliente fcc) {

        this.fcc = fcc;

        this.fcc.getBtSalvarCliente().addActionListener(this);

        this.fcc.getBtPesquisarCliente().addActionListener(this);

        this.fcc.getBtExcluirCliente().addActionListener(this);

        this.fcc.getTabelaCliente().addMouseListener(this);
        
        this.fcc.getBtAtualizaCliente().addActionListener(this);
        
        atualizaTabela();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == fcc.getBtSalvarCliente()) {

            try {
                cliente = new Cliente();
                cliente.setNome(fcc.getCtNomeCliente().getText());
                cliente.setTelefone((String) fcc.getCtTelefone().getValue());
                Date dataNascimento = (Date) fcc.getCtDataNascimento().getValue();
                cliente.setDataNascimento(dataNascimento);
                cliente.setLogradouro(fcc.getCtLogradouro().getText());
                cliente.setNumeroCasa(Integer.parseInt(fcc.getCtNumero().getText()));
                cliente.setBairro(fcc.getCtBairro().getText());
                cliente.setCidade(fcc.getCtCidade().getText());
                cliente.setComplemento(fcc.getCtComplemento().getText());
                cliente.setPontoRef(fcc.getCtPontoRef().getText());

                mc.cadastraCliente(cliente);

                JOptionPane.showMessageDialog(fcc, "Conta cadastrada com sucesso!");
                fcc.getBtAtualizaCliente().setEnabled(true);
                atualizaTabela();

                fcc.getCtNomeCliente().setText("");
                fcc.getCtTelefone().setText("");
                fcc.getCtDataNascimento().setText("");
                fcc.getCtDataNascimento().setText("");
                fcc.getCtLogradouro().setText("");
                fcc.getCtNumero().setText("");
                fcc.getCtBairro().setText("");
                fcc.getCtCidade().setText("");
                fcc.getCtComplemento().setText("");
                fcc.getCtPontoRef().setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Para Realizar o Cadastro os Campos devem ser Todos e Corretamente PREENCHIOS.");

            }

        } else if (e.getSource() == fcc.getBtPesquisarCliente()) {

            if (fcc.getRdNome().isSelected()) {
                String nome = fcc.getCtPesquisarCliente().getText();

                try {
                    listCli = mc.listCliente(nome);
                    DefaultTableModel tableModel = (DefaultTableModel) fcc.getTabelaCliente().getModel();
                    tableModel.setNumRows(0);

                    for (Cliente cliente : listCli) {

                        Object[] linha = {
                            cliente.getNome(),
                            cliente.getTelefone()};

                        tableModel.addRow(linha);

                    }
                    fcc.getCtPesquisarCliente().requestFocus();
                    fcc.getCtPesquisarCliente().selectAll();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Este Cliente não foi encontrado");
                }
                if (fcc.getRdTelefone().isSelected()) {
                    String tel = fcc.getCtPesquisarCliente().getText();
                    try {

                        ArrayList<Cliente> listCli = mc.listCliente();
                        DefaultTableModel tableModel = (DefaultTableModel) fcc.getTabelaCliente().getModel();
                        tableModel.setNumRows(0);

                        for (Cliente cliente : listCli) {

                            Object[] linha = {
                                cliente.getNome(),
                                cliente.getTelefone()};

                            tableModel.addRow(linha);

                        }

                        fcc.getCtPesquisarCliente().requestFocus();
                        fcc.getCtPesquisarCliente().selectAll();

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Este Cliente não foi encontrado");
                    }
                }
            }
        } else if (e.getSource() == fcc.getBtExcluirCliente()) {

            if (fcc.getTabelaCliente().getSelectedRowCount() != 1) {
                JOptionPane.showMessageDialog(null, "Selecione apenas uma linha ");
            } else {

                try {

                    mc.excluiCliente(cliente);
                    JOptionPane.showMessageDialog(fp, "Cliente excluido com sucesso");
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

        } else if(e.getSource() == fcc.getBtAtualizaCliente()){
            
            try {
                
              
                mc.editarCliente(cliente);
                JOptionPane.showMessageDialog(fp, "Cliente Atualizado com sucesso");
                atualizaTabela();
                
                fcc.getBtSalvarCliente().setEnabled(true);
            } catch (Exception ex) {
                Logger.getLogger(FrameCadastroClienteControle.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == fcc.getTabelaCliente()) {

            if (e.getClickCount() == 1) {

                if (fcc.getTabelaCliente().getSelectedRowCount() == 1) {

                    int linha = fcc.getTabelaCliente().getSelectedRow();
                    cliente = listCli.get(linha);


                }

            } else if (e.getClickCount() == 2) {
                
                 fcc.getBtAtualizaCliente().setEnabled(true); 
                 fcc.getBtSalvarCliente().setEnabled(false);
                
                 int linha = fcc.getTabelaCliente().getSelectedRow();
                 cliente = listCli.get(linha);
                 try {
                 fcc.getCtNomeCliente().setText(cliente.getNome());
                 fcc.getCtTelefone().setValue(cliente.getTelefone());
                 
                 fcc.getCtDataNascimento().setValue(cliente.getDataNascimento());
                 fcc.getCtLogradouro().setText(cliente.getLogradouro());
                 fcc.getCtNumero().setText(String.valueOf(cliente.getNumeroCasa()));
                 fcc.getCtBairro().setText(cliente.getBairro());
                 fcc.getCtCidade().setText(cliente.getCidade());
                 fcc.getCtComplemento().setText(cliente.getComplemento());
                 fcc.getCtPontoRef().setText(cliente.getPontoRef());
                
                    
                } catch (Exception ex) {
                    Logger.getLogger(FrameCadastroClienteControle.class.getName()).log(Level.SEVERE, null, ex);
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
            listCli = mc.listCliente();
            DefaultTableModel tableModel = (DefaultTableModel) fcc.getTabelaCliente().getModel();
            tableModel.setNumRows(0);

            for (Cliente cliente : listCli) {

                Object[] linha = {
                    
                    cliente.getNome(),
                    cliente.getTelefone()};

                tableModel.addRow(linha);

            }
            fcc.getCtPesquisarCliente().requestFocus();
            fcc.getCtPesquisarCliente().selectAll();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Nenhum cliente encontrado");
        }
    }

}
