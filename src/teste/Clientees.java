/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import dao.ClienteDAO;
import java.sql.SQLException;
import modelo.Cliente;

/**
 *
 * @author sala306b
 */
public class Clientees {

    public static void main(String[] args) throws SQLException {

        ClienteDAO dao = new ClienteDAO();
        Cliente cli = new Cliente();

        cli.setNome("Frann");

        cli = dao.pesquisa("nome", "aaa");

        System.out.println("Nome: " + cli.getNome());
        System.out.println("Data: " + cli.getDataNascimento());

    }
}
