package br.edu.fapi.webticket.usuario.dao;

import br.edu.fapi.webticket.usuario.modelo.Usuario;

public interface UsuarioDAO {
	Usuario fazerLogin(String login, String Senha);
	Boolean criarUsuario(Usuario usuario);
	Boolean deletarUsario(int id);
	Boolean editarUsuario(Usuario usario);
}
