/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author sala306b
 */
public class BDMySQL {
    
    private final String SERVIDOR = "localhost";
    private final String USUARIO = "root";
    private final String SENHA = "123456";
    private final String BANCO = "dblanchonete";
    private final String URL = "jdbc:mysql://" +   SERVIDOR + "/" + BANCO;
    private final String DRIVER = "com.mysql.jdbc.Driver";

    //Atributo de acesso a conexão com o banco
    public static Connection connection = null;
    

    public BDMySQL() throws SQLException {
        if (connection == null) {
            try {
                
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USUARIO, SENHA);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Problemas com o Driver do MySQL\n"
                        + "Não está instalado ou não está funcionando");
            } catch (SQLException ex) {
                throw new SQLException("Erro ao estabelecer conexão com o MySQL <br>"
                        + "Código do erro: " + ex.getErrorCode() + "<br>"
                        + "Status: " + ex.getSQLState());
            }
        }
    }

    public Connection getConnection() {
        try {
            if (connection == null) {
                throw new Exception("A conexão ainda não foi estabelecida");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return connection;
    }

    public void fechaConexao() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao encerrar conexão");
            }
        }
    }
}
