package br.edu.fapi.webticket.ticket.dao;

import br.edu.fapi.webticket.ticket.modelo.Ticket;
import br.edu.fapi.webticket.ticket.modelo.TicketConversa;

import java.sql.SQLException;
import java.util.List;

public interface TicketConversaDAO {
    List<TicketConversa> listarTicketsConversa(int idTicket) throws SQLException;
    Ticket selecionarTicketConversa(int idTicketConversa) throws SQLException;
    boolean criarTicketConversa(TicketConversa ticketConversa) throws SQLException;
    boolean deletarTicketConversa(int id) throws SQLException;
    boolean editarTicketConversa(TicketConversa ticket) throws SQLException;
}
