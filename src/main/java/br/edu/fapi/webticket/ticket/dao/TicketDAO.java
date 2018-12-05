package br.edu.fapi.webticket.ticket.dao;

import br.edu.fapi.webticket.ticket.modelo.Ticket;

import java.sql.SQLException;
import java.util.List;

public interface TicketDAO {

    List<Ticket> listarTickets() throws SQLException;
    List<Ticket> listarTicketsCliente(int Id) throws SQLException;
    Ticket selecionarTicket(int id) throws SQLException;
    Ticket selecionarTicket(String titulo) throws SQLException;
    boolean criarTicket(Ticket ticket) throws SQLException;
    boolean deletarTicket(int id) throws SQLException;
    boolean editarTicket(Ticket ticket) throws SQLException;
}
