package br.edu.fapi.webticket.cliente.dao;

import br.edu.fapi.webticket.cliente.modelo.Cliente;
import com.mysql.fabric.xmlrpc.Client;

import java.util.List;

public interface ClienteDAO {
    List<Client> listarClientes();
    Cliente selecionarCliente(int id);
    Cliente selecionarCliente(String login);
    boolean detetarCliente(int id);
    boolean editarCliente(Cliente cliente);
}
