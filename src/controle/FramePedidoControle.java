/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import visao.FramePedido;

/**
 *
 * @author sala306b
 */
public class FramePedidoControle implements ActionListener {

    FramePedido fpe;
    
    public FramePedidoControle(FramePedido fp) {
        this.fpe = fp;
        this.fpe.setVisible(true);
        this.fpe.getBtAdicionarPedido().addActionListener(this);
        
        
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
     
        if(e.getSource() == fpe.getBtAdicionarPedido()){
            
            JOptionPane.showMessageDialog(fpe, "<html>"
                        + "<font color=blue size=4><b>"
                        + "Conta cadastrada com sucesso"
                        + "</b></font>"
                        + "</html>");

        }
        
        
    }
    
}
