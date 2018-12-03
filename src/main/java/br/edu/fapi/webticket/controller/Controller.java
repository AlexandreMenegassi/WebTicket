package br.edu.fapi.webticket.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/controller")
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");
        if("home".equals(acao)){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/home.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
