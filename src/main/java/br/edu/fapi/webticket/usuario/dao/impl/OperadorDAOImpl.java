package br.edu.fapi.webticket.usuario.dao.impl;

import br.edu.fapi.webticket.dao.MySqlConnection;
import br.edu.fapi.webticket.usuario.modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperadorDAOImpl extends UsuarioDAOImpl {

    @Override
    public Boolean criarUsuario(Usuario usuario) throws SQLException {
        usuario.setAdmin(false);
        usuario.setOperador(true);
        usuario.setCliente(false);
        return super.criarUsuario(usuario);
    }

    @Override
    public Boolean editarUsuario(Usuario usuario) throws SQLException{
        return super.editarUsuario(usuario);
    }

    @Override
    public List<Usuario> listarUsuario() throws SQLException{
        List<Usuario> jogos = new ArrayList<>();
        try (Connection connection = MySqlConnection.abrirConexao()) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from usuario where operador = 1", Statement.RETURN_GENERATED_KEYS);

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
                jogos.add(usuario);
            }

            return jogos;
        } catch (SQLException e) {
            System.out.println("Conexão não estabelecida.");
            System.out.println(e.getMessage());
        }
        return null;
    }
}
