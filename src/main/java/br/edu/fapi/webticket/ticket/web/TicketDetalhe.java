package br.edu.fapi.webticket.ticket.web;

import br.edu.fapi.webticket.ticket.dao.TicketConversaDAO;
import br.edu.fapi.webticket.ticket.dao.TicketDAO;
import br.edu.fapi.webticket.ticket.dao.impl.TicketConversaDAOImpl;
import br.edu.fapi.webticket.ticket.dao.impl.TicketDAOImpl;
import br.edu.fapi.webticket.ticket.modelo.Ticket;
import br.edu.fapi.webticket.ticket.modelo.TicketConversa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/ticketDetalhe")
public class TicketDetalhe extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idTicket = Integer.parseInt(req.getParameter("idTicket"));

        TicketDAO ticketDAO = new TicketDAOImpl();
        TicketConversaDAO ticketConversaDAO = new TicketConversaDAOImpl();

        try{
            Ticket ticket = ticketDAO.selecionarTicket(idTicket);
            req.setAttribute("ticket",ticket);

            List<TicketConversa> ticketConversas = ticketConversaDAO.listarTicketsConversa(ticket.getIdTicket());
            req.setAttribute("ticketConversas",ticketConversas);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/tickets/detalheticket.jsp");
            requestDispatcher.forward(req, resp);

        }catch (SQLException ex){
            ex.printStackTrace();
        }


    }
}
