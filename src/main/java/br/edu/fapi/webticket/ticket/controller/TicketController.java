package br.edu.fapi.webticket.ticket.controller;

import br.edu.fapi.webticket.ticket.dao.TicketDAO;
import br.edu.fapi.webticket.ticket.dao.impl.TicketDAOImpl;
import br.edu.fapi.webticket.ticket.modelo.Ticket;
import br.edu.fapi.webticket.usuario.modelo.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/ticketController")
public class TicketController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");
        if ("criar".equals(acao)) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/tickets/criarticket.jsp");
            requestDispatcher.forward(req, resp);
        }else if("manter".equals(acao)){
            HttpSession session = req.getSession(true);
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            List<Ticket> tickets = new ArrayList<>();
            TicketDAO ticketDAO = new TicketDAOImpl();

            if(usuario.isCliente()){
                try {
                    tickets = ticketDAO.listarTicketsCliente(usuario.getIdUsuario());
                    req.setAttribute("tickets",tickets);
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/tickets/listarticket.jsp");
                    requestDispatcher.forward(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    tickets = ticketDAO.listarTickets();
                    req.setAttribute("tickets",tickets);
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/tickets/listarticket.jsp");
                    requestDispatcher.forward(req, resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                ;
            }
        }
    }
}
