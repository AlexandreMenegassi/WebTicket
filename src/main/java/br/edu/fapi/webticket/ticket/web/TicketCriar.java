package br.edu.fapi.webticket.ticket.web;

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
import java.sql.Timestamp;

@WebServlet(urlPatterns = "/ticketCriar")
public class TicketCriar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String titulo = req.getParameter("titulo");
        String descricao = req.getParameter("descricao");

        Ticket ticket = new Ticket();
        TicketDAO ticketDAO = new TicketDAOImpl();

        HttpSession session = req.getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        ticket.setIdUsuario(usuario.getIdUsuario());
        ticket.setTitulo(titulo);
        ticket.setDescricao(descricao);
        ticket.setDataCriacao(new Timestamp(System.currentTimeMillis()));

        try{
            ticketDAO.criarTicket(ticket);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("//WEB-INF/pages/tickets/sucessticket.jsp");
            requestDispatcher.forward(req,resp);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
