package br.edu.fapi.webticket.ticket.dao.impl;

import br.edu.fapi.webticket.ticket.dao.TicketDAO;
import br.edu.fapi.webticket.ticket.modelo.Ticket;

import java.sql.SQLException;
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
