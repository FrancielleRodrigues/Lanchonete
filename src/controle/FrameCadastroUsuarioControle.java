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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.ManipulaUsuario;
import modelo.Usuario;
import visao.FrameCadastroUsuario;

/**
 *
 * @author sala306b
 */
public class FrameCadastroUsuarioControle  implements ActionListener ,  MouseListener{
    
    FrameCadastroUsuario fcad ;
    ManipulaUsuario musu = new ManipulaUsuario();
    Usuario us = new Usuario();
    

    public FrameCadastroUsuarioControle(FrameCadastroUsuario fcad) {
        this.fcad = fcad;
        
        
        this.fcad.getBtCadastrarUsuario().addActionListener(this);
        
        this.fcad.getListUsuario().addMouseListener(this);
        
       
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == fcad.getBtCadastrarUsuario()) {
           
//             try {
//                 
//            us.setLogin(fcad.getCtUsuario().getText());
//            us.setSenha(fcad.getCtSenha().getText());
//            
//           
//           musu.cadastra(us);
//           
//           
//            
//           JOptionPane.showMessageDialog(fcad, "Conta cadastrada com sucesso!");
//           
//           fcad.getCtUsuario().setText("");
//           fcad.getCtSenha().setText("");
//           
//           
//           
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(fcad, ex);
//                ex.printStackTrace();
//            }
//          
        
    }
       
    }
    
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
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
    }

  
    
    

