/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Interface.ClienteBO;
import dao.ClienteDAO;
import java.util.ArrayList;

/**
 *
 * @author Elzi
 */
public class ManipulaCliente implements ClienteBO {

    @Override
    public void cadastraCliente(Cliente cliente) throws Exception {

        if (cliente.getNome().isEmpty()) {
            throw new Exception("O NOME do cliente é obrigatório");
        } else if (cliente.getTelefone().isEmpty()) {
            throw new Exception("O TELEFONE do cliente é obrigatório");
        } else if (cliente.getLogradouro().isEmpty()) {
            throw new Exception("O LOGRADOURO do cliente é obrigatório");
        } else if (cliente.getBairro().isEmpty()) {
            throw new Exception("O BAIRRO do cliente é obrigatório");
        } else if (cliente.getCidade().isEmpty()) {
            throw new Exception("A CIDADE do cliente é obrigatório");
        } else if (cliente.getPontoRef().isEmpty()) {
            throw new Exception("O PONTO DE REFERÊNCIA Nome do cliente é obrigatório");
        }

        ClienteDAO cdao = new ClienteDAO();
        cdao.cadastra(cliente);

    }

    
    @Override
    public Cliente pesquisaCliente(int telefone) throws Exception {
        if (telefone == 0 || String.valueOf(telefone).isEmpty()) {
            throw new Exception("O numero de TELEFONE informado é inválido.");
        }

        ClienteDAO cdao = new ClienteDAO();
        return cdao.pesquisa("telefone", telefone);

    }

    @Override
    public Cliente pesquisaCliente(String nome) throws Exception {
        if (nome.equals("")) {
            throw new Exception("O nome do CLIENTE informado é inválido");
        }

        ClienteDAO cdao = new ClienteDAO();
        return cdao.pesquisa("nome", nome);
    }

    @Override
    public ArrayList<Cliente> listCliente() throws Exception {
        ClienteDAO cdao = new ClienteDAO();
        return cdao.listCliente();

    }

    @Override
    public ArrayList<Cliente> listCliente(String nome) throws Exception {
        ClienteDAO cdao = new ClienteDAO();
        return cdao.pesquisa(nome);
    }

    @Override
    public void excluiCliente(Cliente cliente) throws Exception {
        ClienteDAO cdao = new ClienteDAO();
        cdao.exclui(cliente);
    }

    @Override
    public void editarCliente( Cliente cliente) throws Exception {
        ClienteDAO cdao = new ClienteDAO();
        cdao.editar(cliente);
    }

  

    

}
