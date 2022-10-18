/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import visao.FrameAniversario;

/**
 *
 * @author sala306b
 */
public class FrameAniversarioControle implements ActionListener{

    FrameAniversario fa;

    public FrameAniversarioControle(FrameAniversario fa) {
        this.fa = fa;
        
        this.fa.setVisible(true);
        
    }
    
    
    
    

   
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
