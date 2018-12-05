package br.edu.fapi.webticket.ticket.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ticketController")
public class TicketController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");
        if ("criar".equals(acao)) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/tickets/criarticket.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
