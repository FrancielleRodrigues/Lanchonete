/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JMenuItem;


import visao.FrameAniversario;
import visao.FrameCadastroCliente;
import visao.FrameCadastroProduto;
import visao.FrameCadastroUsuario;
import visao.FramePedido;
import visao.FramePrincipal;


/**
 *
 * @author sala306b
 */
public class FramePrincipalControle implements ActionListener , KeyListener{

    
   FramePrincipal fpp ;
   FrameCadastroCliente cc ;
   FrameCadastroUsuario fu;
   FramePedido fp;
   JMenuItem menuItem;
   FrameCadastroProduto fcp;

  
    

    public FramePrincipalControle(FramePrincipal fp) {
        
       this.fpp = fp;
       this.fpp.setVisible(true);
       this.fpp.getMenu().addActionListener(this);
//       this.fpp.getArea_trabalho().setVisible(true);
       this.fpp.getCadastros().addActionListener(this);
       this.fpp.getPedidos().addActionListener(this);
       this.fpp.getmNovoUsuario().addActionListener(this);
       this.fpp.getmNovoPedido().addActionListener(this);
       this.fpp.getmCadastroClientes().addActionListener(this);
       this.fpp.getmCadastroProdutos().addActionListener(this);
       this.fpp.getmSair().addActionListener(this);
       
       
       
       
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
       //ações para os itens do item PEDIDOS
        
    if( e.getSource() == fpp.getmNovoPedido() ){
      
         FramePedido obj = new FramePedido();
         this.fpp.getArea().add(obj);
         obj.setVisible(true);
         new FramePedidoControle(fp);
         
       
    }
    
  
    //ações para os itens do item CADASTROS
    
    else if(e.getSource() == fpp.getmCadastroProdutos()){
      FrameCadastroProduto fcp = new FrameCadastroProduto();
      this.fpp.getArea().add(fcp);
      fcp.setVisible(true);
      fcp.getBtAtualizar().setEnabled(false); 
      new FrameCadastroProdutoControle(fcp);
      
   
      
    }
    else if(e.getSource() == fpp.getmCadastroClientes()){
      FrameCadastroCliente fcc = new FrameCadastroCliente();
      this.fpp.getArea().add(fcc);
      fcc.setVisible(true);
      fcc.getBtAtualizaCliente().setEnabled(false);   
      new FrameCadastroClienteControle(fcc);
    }
     
    
    //ações para os item do item MENU
    
    else if(e.getSource() == fpp.getmSair()){
        this.fpp.dispose();
    }
    else if(e.getSource() == fpp.getmAjuda()){
      
          
    }
    else if(e.getSource() == fpp.getmAniversarios()){
      FrameAniversario fa = new FrameAniversario();
       this.fpp.getArea().add(fa);
       fa.setVisible(true);
       new FrameAniversarioControle(fa);
    }
    
    
    else if(e.getSource() == fpp.getmNovoUsuario()){
        FrameCadastroUsuario fcu = new FrameCadastroUsuario();
        this.fpp.getArea().add(fcu);
        fcu.setVisible(true); 
        new FrameCadastroUsuarioControle(fcu);
    }
  
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    
    
}
