/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;



import controle.FramePrincipalControle;



import visao.FramePrincipal;



/**
 *
 * @author sala306b
 */
public class Principal {
    
    public static void main(String[] args){
        FramePrincipal fp = new FramePrincipal();
        new FramePrincipalControle(fp);
        
 
    }
    
}
