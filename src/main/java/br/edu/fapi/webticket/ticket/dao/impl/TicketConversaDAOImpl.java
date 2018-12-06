package br.edu.fapi.webticket.ticket.dao.impl;

import br.edu.fapi.webticket.dao.MySqlConnection;
import br.edu.fapi.webticket.ticket.dao.TicketConversaDAO;
import br.edu.fapi.webticket.ticket.modelo.Ticket;
import br.edu.fapi.webticket.ticket.modelo.TicketConversa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketConversaDAOImpl implements TicketConversaDAO {

    @Override
    public List<TicketConversa> listarTicketsConversa(int idTicket) throws SQLException {
        List<TicketConversa> ticketConversas = new ArrayList<>();
        try (Connection connection = MySqlConnection.abrirConexao()) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(" select TicketConversa.*, Usuario.Login from TicketConversa where IdTicket = " + idTicket +" join Usuario on Usuario.IdUsuario = TicketConversa.IdUsuario;", Statement.RETURN_GENERATED_KEYS);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                TicketConversa ticketConversa = new TicketConversa();

                ticketConversa.setIdTicketConversa(resultSet.getInt("IdTicket"));
                ticketConversa.setIdTicket(resultSet.getInt("IdTicketConversa"));
                ticketConversa.setIdUsuario(resultSet.getInt("IdUsuario"));
                ticketConversa.setConteudo(resultSet.getString("Conteudo"));
                ticketConversa.setDataPostagem(resultSet.getTimestamp("DataPostagem"));
                ticketConversa.setUsuarioNome(resultSet.getString("Login"));

                ticketConversas.add(ticketConversa);
            }
            return ticketConversas;
        } catch (SQLException e) {
            System.out.println("Conexão não estabelecida.");
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Ticket selecionarTicketConversa(int idTicketConversa) throws SQLException {
        return null;
    }

    @Override
    public boolean criarTicketConversa(TicketConversa ticketConversa) throws SQLException {
        return false;
    }

    @Override
    public boolean deletarTicketConversa(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean editarTicketConversa(TicketConversa ticket) throws SQLException {
        return false;
    }
}
