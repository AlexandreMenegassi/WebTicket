package br.edu.fapi.webticket.operador.dao;

import br.edu.fapi.webticket.cliente.modelo.Cliente;
import br.edu.fapi.webticket.operador.modelo.Operador;

import java.util.List;

public interface OperadorDAO {
    List<Operador> listarOperadors();
    Operador selecionarOperador(int id);
    Operador selecionarOperador(String login);
    boolean detetarOperador(int id);
    boolean editarOperador(Cliente cliente);
}
