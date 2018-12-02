package br.edu.fapi.webticket.usuario.dao;

import br.edu.fapi.webticket.usuario.modelo.Usuario;

import java.util.List;

public interface UsuarioDAO {
	Usuario selecionarUsuario(String login, String Senha);
	Boolean criarUsuario(Usuario usuario);
	Boolean deletarUsario(int id);
	Boolean editarUsuario(Usuario usario);
	List<Usuario> listarUsuario();
}
