package br.edu.fapi.webticket.ticket.dao.impl;

import br.edu.fapi.webticket.dao.MySqlConnection;
import br.edu.fapi.webticket.ticket.dao.TicketDAO;
import br.edu.fapi.webticket.ticket.modelo.Ticket;
import br.edu.fapi.webticket.usuario.modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAOImpl implements TicketDAO {
    @Override
    public List<Ticket> listarTickets() throws SQLException {
        List<Ticket> tickets = new ArrayList<>();
        try (Connection connection = MySqlConnection.abrirConexao()) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select Ticket.*,Usuario.Login from Ticket join Usuario on Ticket.IdUsuario = Usuario.IdUsuario", Statement.RETURN_GENERATED_KEYS);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Ticket ticket = new Ticket();
                ticket.setIdTicket(resultSet.getInt("IdTicket"));
                ticket.setIdUsuario(resultSet.getInt("IdUsuario"));
                ticket.setTitulo(resultSet.getString("Titulo"));
                ticket.setDescricao(resultSet.getString("Descricao"));
                ticket.setDataCriacao(resultSet.getTimestamp("DataCriacao"));
                ticket.setDataFechamento(resultSet.getTimestamp("DataFechamento"));
                ticket.setUsuarioNome(resultSet.getString("Login"));

                tickets.add(ticket);
            }

            return tickets;
        } catch (SQLException e) {
            System.out.println("Conexão não estabelecida.");
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Ticket> listarTicketsCliente(int Id) throws SQLException {
        List<Ticket> tickets = new ArrayList<>();
        try (Connection connection = MySqlConnection.abrirConexao()) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select Ticket.*,Usuario.Login from Ticket join Usuario on Ticket.IdUsuario = Usuario.IdUsuario where Ticket.IdUsuario = " + Id, Statement.RETURN_GENERATED_KEYS);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Ticket ticket = new Ticket();
                ticket.setIdTicket(resultSet.getInt("IdTicket"));
                ticket.setIdUsuario(resultSet.getInt("IdUsuario"));
                ticket.setTitulo(resultSet.getString("Titulo"));
                ticket.setDescricao(resultSet.getString("Descricao"));
                ticket.setDataCriacao(resultSet.getTimestamp("DataCriacao"));
                ticket.setDataFechamento(resultSet.getTimestamp("DataFechamento"));
                ticket.setUsuarioNome(resultSet.getString("Login"));

                tickets.add(ticket);
            }

            return tickets;
        } catch (SQLException e) {
            System.out.println("Conexão não estabelecida.");
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Ticket selecionarTicket(int id) throws SQLException {
        Ticket ticket = null;
        try (Connection connection = MySqlConnection.abrirConexao()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select Ticket.*,Usuario.Login from Ticket join Usuario on Ticket.IdUsuario = Usuario.IdUsuario where Ticket.IdTicket = ?",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.first()) {
                ticket = new Ticket();
                ticket.setIdTicket(resultSet.getInt("IdTicket"));
                ticket.setIdUsuario(resultSet.getInt("IdUsuario"));
                ticket.setTitulo(resultSet.getString("Titulo"));
                ticket.setDescricao(resultSet.getString("Descricao"));
                ticket.setDataCriacao(resultSet.getTimestamp("DataCriacao"));
                ticket.setDataFechamento(resultSet.getTimestamp("DataFechamento"));
                ticket.setUsuarioNome(resultSet.getString("Login"));
                return ticket;
            }
        } catch (SQLException e) {
            System.out.println("Conexão não estabelecida.");
            System.out.println(e.getMessage());
        }
        return ticket;
    }

    @Override
    public Ticket selecionarTicket(String titulo) throws SQLException {
        return null;
    }

    @Override
    public boolean criarTicket(Ticket ticket) throws SQLException {
        try (Connection connection = MySqlConnection.abrirConexao()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into ticket(Titulo, Descricao, IdUsuario, DataCriacao) values (?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,ticket.getTitulo());
            preparedStatement.setString(2,ticket.getDescricao());
            preparedStatement.setInt(3,ticket.getIdUsuario());
            preparedStatement.setTimestamp(4,ticket.getDataCriacao());

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
    public boolean deletarTicket(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean editarTicket(Ticket ticket) throws SQLException {
        try(Connection connection = MySqlConnection.abrirConexao()){
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update ticket set DataFechamento = ? where IdTicket = "+ ticket.getIdTicket(),
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setTimestamp(1,ticket.getDataFechamento());

            int resultado = preparedStatement.executeUpdate();
            System.out.println("Registro alterado");
            return true;

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    @Override
    public List<Ticket> listarTicketsClienteFechado(int Id) throws SQLException {
        List<Ticket> tickets = new ArrayList<>();
        try (Connection connection = MySqlConnection.abrirConexao()) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select Ticket.*,Usuario.Login from Ticket join Usuario on Ticket.IdUsuario = Usuario.IdUsuario where DataFechamento is not null and Ticket.IdUsuario = " + Id, Statement.RETURN_GENERATED_KEYS);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Ticket ticket = new Ticket();
                ticket.setIdTicket(resultSet.getInt("IdTicket"));
                ticket.setIdUsuario(resultSet.getInt("IdUsuario"));
                ticket.setTitulo(resultSet.getString("Titulo"));
                ticket.setDescricao(resultSet.getString("Descricao"));
                ticket.setDataCriacao(resultSet.getTimestamp("DataCriacao"));
                ticket.setDataFechamento(resultSet.getTimestamp("DataFechamento"));
                ticket.setUsuarioNome(resultSet.getString("Login"));

                tickets.add(ticket);
            }

            return tickets;
        } catch (SQLException e) {
            System.out.println("Conexão não estabelecida.");
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean reabritTicket(Ticket ticket) throws SQLException {
        try(Connection connection = MySqlConnection.abrirConexao()){
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update ticket set DataFechamento = null where IdTicket = "+ ticket.getIdTicket(),
                    Statement.RETURN_GENERATED_KEYS);

            int resultado = preparedStatement.executeUpdate();
            System.out.println("Registro alterado");
            return true;

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
