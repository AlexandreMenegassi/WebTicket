package br.edu.fapi.webticket.usuario.dao.impl;

import br.edu.fapi.webticket.usuario.modelo.Usuario;

import java.sql.SQLException;
import java.util.List;

public class OperadorDAOImpl extends UsuarioDAOImpl {
    @Override
    public Usuario selecionarUsuario(String login, String Senha) {
        return super.selecionarUsuario(login,Senha);
    }

    @Override
    public Boolean criarUsuario(Usuario usuario) throws SQLException {
        usuario.setAdmin(false);
        usuario.setOperador(true);
        usuario.setCliente(false);
        return super.criarUsuario(usuario);
    }

    @Override
    public Boolean deletarUsario(int id) throws SQLException {
        return super.deletarUsario(id);
    }

    @Override
    public Boolean editarUsuario(Usuario usuario) {
        return super.editarUsuario(usuario);
    }

    @Override
    public List<Usuario> listarUsuario() {
        return super.listarUsuario();
    }
}
