package br.edu.fapi.webticket.usuario.dao.impl;

import br.edu.fapi.webticket.dao.MySqlConnection;
import br.edu.fapi.webticket.usuario.modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl extends UsuarioDAOImpl {
    @Override
    public List<Usuario> listarUsuario() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        try (Connection connection = MySqlConnection.abrirConexao()) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from usuario where cliente = 1", Statement.RETURN_GENERATED_KEYS);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(resultSet.getInt("IdUsuario"));
                usuario.setIdUsuarioDetalhe(resultSet.getInt("IdUsuarioDetalhe"));
                usuario.setLogin(resultSet.getString("Login"));
                usuario.setSenha(resultSet.getString("Senha"));
                usuario.setCliente(resultSet.getBoolean("Cliente"));
                usuario.setOperador(resultSet.getBoolean("Operador"));
                usuario.setAdmin(resultSet.getBoolean("Admin"));
                usuarios.add(usuario);
            }

            return usuarios;
        } catch (SQLException e) {
            System.out.println("Conexão não estabelecida.");
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Boolean criarUsuario(Usuario usuario) throws SQLException {
        usuario.setAdmin(false);
        usuario.setOperador(false);
        usuario.setCliente(true);
        return super.criarUsuario(usuario);
    }
}
