package br.edu.fapi.webticket.ticket.dao.impl;

import br.edu.fapi.webticket.dao.MySqlConnection;
import br.edu.fapi.webticket.ticket.dao.TicketDAO;
import br.edu.fapi.webticket.ticket.modelo.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TicketDAOImpl implements TicketDAO {
    @Override
    public List<Ticket> listarTickets() throws SQLException {
        return null;
    }

    @Override
    public Ticket selecionarTicket(int id) throws SQLException {
        return null;
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
        return false;
    }
}
