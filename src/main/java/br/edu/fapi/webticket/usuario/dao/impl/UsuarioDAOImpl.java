package br.edu.fapi.webticket.usuario.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.fapi.webticket.dao.MySqlConnection;
import br.edu.fapi.webticket.usuario.dao.UsuarioDAO;
import br.edu.fapi.webticket.usuario.modelo.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO{

    private Connection connection;

    @Override
	public Usuario fazerLogin(String login, String senha) {
        Usuario usuario = null;
		try (Connection connection = MySqlConnection.abrirConexao()) {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from usuario where Senha = ? and Login = ?",
			Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, senha);
			preparedStatement.setString(2, login);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.first()) {
                usuario = new Usuario();
				usuario.setIdUsario(resultSet.getInt("IdUsuario"));
				usuario.setLogin(resultSet.getString("Login"));
				usuario.setSenha(resultSet.getString("Senha"));
				usuario.setAdmin(resultSet.getBoolean("Admin"));
				usuario.setCliente(resultSet.getBoolean("Cliente"));
				usuario.setOperador(resultSet.getBoolean("Operador"));
				usuario.setStatus(resultSet.getInt("Status"));
				return usuario;
			}
		} catch (SQLException e) {
			System.out.println("Conexão não estabelecida.");
			System.out.println(e.getMessage());
		}
		return usuario;
	}

	@Override
	public Boolean criarUsuario(Usuario usuario) {
		try (Connection connection = MySqlConnection.abrirConexao()) {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into usuario(Login, Senha, Admin, Operador, Cliente) values (?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, usuario.getLogin());
			preparedStatement.setString(2, usuario.getSenha());
			preparedStatement.setBoolean(3, usuario.isAdmin());
			preparedStatement.setBoolean(4, usuario.isOperador());
			preparedStatement.setBoolean(5, usuario.isCliente());


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
	public Boolean deletarUsario(int id) {
		try (Connection connection = MySqlConnection.abrirConexao()) {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from usuario where IdUsuario = ?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			System.out.println("Conexão não estabelecida.");
			System.out.println(e);
			return false;
		}
	}

    @Override
    public Boolean editarUsuario(Usuario usario) {
        //TODO implementar editar usuario
        return null;
    }


}
