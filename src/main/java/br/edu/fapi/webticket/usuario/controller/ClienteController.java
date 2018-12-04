package br.edu.fapi.webticket.usuario.controller;

import br.edu.fapi.webticket.usuario.dao.UsuarioDAO;
import br.edu.fapi.webticket.usuario.dao.impl.ClienteDAOImpl;
import br.edu.fapi.webticket.usuario.dao.impl.OperadorDAOImpl;
import br.edu.fapi.webticket.usuario.modelo.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/clienteController")
public class ClienteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");
        if("manter".equals(acao)){
            List<Usuario> clientes = new ArrayList<>();
            UsuarioDAO clienteDAO = new ClienteDAOImpl();
            try {
                clientes = clienteDAO.listarUsuario();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.setAttribute("clientes",clientes);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/cliente/listarcliente.jsp");
            requestDispatcher.forward(req, resp);
        }else if("criar".equals(acao)){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/cliente/criarcliente.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
