package br.edu.fapi.webticket.usuario.controller;

import br.edu.fapi.webticket.usuario.dao.UsuarioDAO;
import br.edu.fapi.webticket.usuario.dao.impl.OperadorDAOImpl;
import br.edu.fapi.webticket.usuario.dao.impl.UsuarioDAOImpl;
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

@WebServlet(urlPatterns = "/operadorController")
public class OperadorController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");
        if("manter".equals(acao)){
            List<Usuario> operadores = new ArrayList<>();
            UsuarioDAO operadorDAO = new OperadorDAOImpl();
            try {
                operadores = operadorDAO.listarUsuario();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.setAttribute("operadores",operadores);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/operador/listaroperador.jsp");
            requestDispatcher.forward(req, resp);
        }else if("criar".equals(acao)){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/operador/criaroperador.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
