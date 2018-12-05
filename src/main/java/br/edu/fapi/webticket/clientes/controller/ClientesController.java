package br.edu.fapi.webticket.clientes.controller;

import br.edu.fapi.webticket.empresa.dao.EmpresaDAO;
import br.edu.fapi.webticket.empresa.dao.impl.EmpresaDAOImpl;
import br.edu.fapi.webticket.empresa.modelo.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/ClientesController")
public class ClientesController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");
        if("novoTopico".equals(acao)) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("#");
            requestDispatcher.forward(req, resp);
        }

        else

        if("listarTopico".equals(acao)) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/usuarios/listartopico.jsp");
            requestDispatcher.forward(req, resp);
        }

        else

        if("responderTopico".equals(acao)) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("#");
            requestDispatcher.forward(req, resp);
        }
    }
}
