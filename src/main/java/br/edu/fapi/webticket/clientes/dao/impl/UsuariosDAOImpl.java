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
                    "insert into usuario(Login, Senha, Admin, Operador, Cliente, Nome, Sobrenome, Idade, Sexo, RG, CPF) values (?,?,?,?,?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, usuario.getLogin());
            preparedStatement.setString(2, usuario.getSenha());
            preparedStatement.setBoolean(3, false);
            preparedStatement.setBoolean(4, false);
            preparedStatement.setBoolean(5, false);
            preparedStatement.setString(6, usuario.getNome());
            preparedStatement.setString(7, usuario.getSobrenome());
            preparedStatement.setString(8, usuario.getIdade());
            preparedStatement.setString(9, usuario.getSexo());
            preparedStatement.setString(10, usuario.getRG());
            preparedStatement.setString(11, usuario.getCPF());

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