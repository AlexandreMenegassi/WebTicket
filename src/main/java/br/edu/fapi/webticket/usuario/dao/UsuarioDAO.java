package br.edu.fapi.webticket.usuario.dao;

import br.edu.fapi.webticket.usuario.modelo.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {
	Usuario selecionarUsuario(String login, String Senha) throws SQLException;
	Usuario selecionarUsuario(int id) throws SQLException;
	Boolean criarUsuario(Usuario usuario) throws SQLException;
	Boolean deletarUsario(int id) throws SQLException;
	Boolean editarUsuario(Usuario usario) throws SQLException;
	List<Usuario> listarUsuario() throws SQLException;
}
