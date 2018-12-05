package br.edu.fapi.webticket.clientes.dao.impl;

import br.edu.fapi.webticket.clientes.dao.UsuariosDAO;
import br.edu.fapi.webticket.clientes.modelo.ModeloCliente;
import br.edu.fapi.webticket.dao.MySqlConnection;
import br.edu.fapi.webticket.usuario.modelo.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.List;

@WebServlet(name = "UsuariosDAOImpl")
public class UsuariosDAOImpl implements UsuariosDAO {

    @Override
    public boolean verificarUsuario(String login) throws SQLException {

        ModeloCliente user = new ModeloCliente();

        try (Connection connection = MySqlConnection.abrirConexao()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select Login from usuario where Login = ?",
            Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, login);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.first()) {
                user.setNome(resultSet.getString("Login"));
            }

            if (login.equals( user.getNome())){
                return true;
            } else
                {
                    return false;
                }

        } catch (SQLException e) {
            System.out.println("Conexão não estabelecida.");
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean criarUsuarios(ModeloCliente usuario) throws SQLException {
        try (Connection connection = MySqlConnection.abrirConexao()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into clientes(Nome, Sobrenome, Idade, Sexo, RG, CPF) values (?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getSobrenome());
            preparedStatement.setString(3, usuario.getIdade());
            preparedStatement.setString(4, usuario.getSexo());
            preparedStatement.setString(5, usuario.getRG());
            preparedStatement.setString(6, usuario.getCPF());

            int resultado = preparedStatement.executeUpdate();
            System.out.println("Registro inserido");
            return true;
        } catch (SQLException e) {
            System.out.println("Conexão não estabelecida.");
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean addLoginSenha(String login, String senha) throws SQLException {
        try (Connection connection = MySqlConnection.abrirConexao()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into usuario(Login, Senha, Admin, Operador, Cliente) values (?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, senha);
            preparedStatement.setInt(3, '0');
            preparedStatement.setInt(4, '0');
            preparedStatement.setInt(5, '0');

            int resultado = preparedStatement.executeUpdate();
            System.out.println("Registro inserido");
            return true;
        } catch (SQLException e) {
            System.out.println("Conexão não estabelecida.");
            System.out.println(e.getMessage());
        }
        return false;
    }

    /*
        @Override
        public List<Usuario> listarUsuarios() throws SQLException {
            return null;
        }
    */
}