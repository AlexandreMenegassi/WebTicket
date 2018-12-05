package br.edu.fapi.webticket.usuario.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.edu.fapi.webticket.dao.MySqlConnection;
import br.edu.fapi.webticket.usuario.dao.UsuarioDAO;
import br.edu.fapi.webticket.usuario.modelo.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO{

    private Connection connection;

    @Override
	public Usuario selecionarUsuario(String login, String senha) throws SQLException {
        Usuario usuario = null;
		try (Connection connection = MySqlConnection.abrirConexao()) {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from usuario where Senha = ? and Login = ?",
			Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, senha);
			preparedStatement.setString(2, login);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.first()) {
                usuario = new Usuario();
				usuario.setIdUsuario(resultSet.getInt("IdUsuario"));
				usuario.setIdUsuarioDetalhe(resultSet.getInt("IdUsuarioDetalhe"));
				usuario.setLogin(resultSet.getString("Login"));
				usuario.setSenha(resultSet.getString("Senha"));
				usuario.setAdmin(resultSet.getBoolean("Admin"));
				usuario.setCliente(resultSet.getBoolean("Cliente"));
				usuario.setOperador(resultSet.getBoolean("Operador"));
				return usuario;
			}
		} catch (SQLException e) {
			System.out.println("Conexão não estabelecida.");
			System.out.println(e.getMessage());
		}
		return usuario;
	}

	@Override
	public Usuario selecionarUsuario(int id) {
		Usuario usuario = null;
		try (Connection connection = MySqlConnection.abrirConexao()) {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from usuario where idUsuario = ?",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.first()) {
				usuario = new Usuario();
				usuario.setIdUsuario(resultSet.getInt("IdUsuario"));
				usuario.setIdUsuarioDetalhe(resultSet.getInt("IdUsuarioDetalhe"));
				usuario.setLogin(resultSet.getString("Login"));
				usuario.setSenha(resultSet.getString("Senha"));
				usuario.setAdmin(resultSet.getBoolean("Admin"));
				usuario.setCliente(resultSet.getBoolean("Cliente"));
				usuario.setOperador(resultSet.getBoolean("Operador"));
				connection.close();
				return usuario;
			}
		} catch (SQLException e) {
			System.out.println("Conexão não estabelecida.");
			System.out.println(e.getMessage());
		}
		return usuario;
	}

	@Override
	public Boolean criarUsuario(Usuario usuario) throws SQLException{
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
	public Boolean deletarUsario(int id) throws SQLException{
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
    public Boolean editarUsuario(Usuario usuario) throws SQLException {
		try(Connection connection = MySqlConnection.abrirConexao()){
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			ResultSet resultSet = statement.executeQuery("select * from usuario where idUsuario = " + usuario.getIdUsuario());

			if (resultSet.first()) {
				resultSet.updateString("Login", usuario.getLogin());
				resultSet.updateString("Senha", usuario.getSenha());
				resultSet.updateInt("IdUsuarioDetalhe",usuario.getIdUsuarioDetalhe());
				resultSet.updateBoolean("Admin",usuario.isAdmin());
				resultSet.updateBoolean("Operador",usuario.isOperador());
				resultSet.updateBoolean("Cliente",usuario.isCliente());
                resultSet.updateRow();
                return resultSet.rowUpdated();
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
    }

	@Override
	public List<Usuario> listarUsuario() throws SQLException {
		List<Usuario> jogos = new ArrayList<>();
		try (Connection connection = MySqlConnection.abrirConexao()) {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from usuario", Statement.RETURN_GENERATED_KEYS);

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
