package br.edu.fapi.webticket.usuario.dao.impl;

import br.edu.fapi.webticket.dao.MySqlConnection;
import br.edu.fapi.webticket.usuario.modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperadorDAOImpl extends UsuarioDAOImpl {

    @Override
    public Boolean criarUsuario(Usuario usuario) throws SQLException {
        try (Connection connection = MySqlConnection.abrirConexao()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into usuario(Login, Senha, Admin, Operador, Cliente,IdUsuarioDetalhe) values (?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, usuario.getLogin());
            preparedStatement.setString(2, usuario.getSenha());
            preparedStatement.setBoolean(3, usuario.isAdmin());
            preparedStatement.setBoolean(4, usuario.isOperador());
            preparedStatement.setBoolean(5, usuario.isCliente());
            preparedStatement.setInt(6, usuario.getIdUsuarioDetalhe());


            // INSERT, UPDATE OU DELETE (executeUpdate())
            // Resultado é um valor int que indica o número de linhas afetadas.
            int resultado = preparedStatement.executeUpdate();
            System.out.println("Registro inserido");
            return true;
        } catch (SQLException e) {
            System.out.println("Conexão não estabelecida.");
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean editarUsuario(Usuario usuario) throws SQLException{
        return super.editarUsuario(usuario);
    }

    @Override
    public List<Usuario> listarUsuario() throws SQLException{
        List<Usuario> usuarios = new ArrayList<>();
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
                usuarios.add(usuario);
            }

            return usuarios;
        } catch (SQLException e) {
            System.out.println("Conexão não estabelecida.");
            System.out.println(e.getMessage());
        }
        return null;
    }
}
