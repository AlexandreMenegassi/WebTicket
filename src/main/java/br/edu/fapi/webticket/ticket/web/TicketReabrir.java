package br.edu.fapi.webticket.ticket.web;

import br.edu.fapi.webticket.ticket.dao.TicketDAO;
import br.edu.fapi.webticket.ticket.dao.impl.TicketDAOImpl;
import br.edu.fapi.webticket.ticket.modelo.Ticket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

@WebServlet(urlPatterns = "/ticketReabrir")
public class TicketReabrir extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idTicket = Integer.parseInt(req.getParameter("idTicket"));
        Ticket ticket = new Ticket();
        TicketDAO ticketDAO = new TicketDAOImpl();
        try {
            ticket = ticketDAO.selecionarTicket(idTicket);
            ticketDAO.reabritTicket(ticket);
            resp.sendRedirect("/ticketController?acao=fechados");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
