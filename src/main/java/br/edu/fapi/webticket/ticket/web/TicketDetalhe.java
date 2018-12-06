package br.edu.fapi.webticket.ticket.web;

import br.edu.fapi.webticket.ticket.dao.TicketConversaDAO;
import br.edu.fapi.webticket.ticket.dao.TicketDAO;
import br.edu.fapi.webticket.ticket.dao.impl.TicketConversaDAOImpl;
import br.edu.fapi.webticket.ticket.dao.impl.TicketDAOImpl;
import br.edu.fapi.webticket.ticket.modelo.Ticket;
import br.edu.fapi.webticket.ticket.modelo.TicketConversa;
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Parametros
        String acao = req.getParameter("acao");
        String resposta = req.getParameter("resposta");
        int idTicket = Integer.parseInt(req.getParameter("idTicket"));

        //Usuario sessao
        HttpSession session = req.getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if("responder".equals(acao)){
            TicketConversa ticketConversa = new TicketConversa();
            TicketConversaDAO ticketConversaDAO = new TicketConversaDAOImpl();

            ticketConversa.setIdTicket(idTicket);
            ticketConversa.setIdUsuario(usuario.getIdUsuario());
            ticketConversa.setDataPostagem(new Timestamp(System.currentTimeMillis()));
            ticketConversa.setConteudo(resposta);

            try {
                ticketConversaDAO.criarTicketConversa(ticketConversa);
                resp.sendRedirect("/ticketController?acao=manter");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }else if("fechar".equals(acao)){

            Ticket ticket = new Ticket();
            TicketDAO ticketDAO = new TicketDAOImpl();

            try {
                ticket = ticketDAO.selecionarTicket(idTicket);
                ticket.setDataFechamento(new Timestamp(System.currentTimeMillis()));
                ticketDAO.editarTicket(ticket);
                resp.sendRedirect("/ticketController?acao=manter");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
