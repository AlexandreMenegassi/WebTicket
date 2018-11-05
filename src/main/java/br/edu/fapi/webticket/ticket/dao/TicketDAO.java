package br.edu.fapi.webticket.ticket.dao;

import br.edu.fapi.webticket.ticket.modelo.Ticket;

import java.util.List;

public interface TicketDAO {
    List<Ticket> listarOperadors();
    Ticket selecionarOperador(int id);
    Ticket selecionarOperador(String login);
    boolean detetarOperador(int id);
    boolean editarOperador(Ticket ticket);
}
