/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import visao.FrameLogin;
import visao.FramePrincipal;

/**
 *
 * @author sala306b
 */
public class FrameLoginControle implements ActionListener{
    
  FrameLogin flogin;

    public FrameLoginControle(FrameLogin fl) {
//        this.flogin.getBtEntar().addActionListener(this);
        this.flogin = fl;
        
    }
  
  

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==flogin.getBtEntar()){
         FramePrincipal framep = new FramePrincipal();
         framep.setVisible(true);
       }
    }
  
  
    
}
