package br.edu.fapi.webticket.clientes.dao;

import br.edu.fapi.webticket.clientes.modelo.ModeloCliente;

import java.sql.SQLException;
import java.util.List;

public interface UsuariosDAO {
    boolean verificarUsuario(String login) throws SQLException;
    boolean criarUsuarios(ModeloCliente user) throws SQLException;

    //List<ModeloCliente> listarUsuarios() throws SQLException;
}
