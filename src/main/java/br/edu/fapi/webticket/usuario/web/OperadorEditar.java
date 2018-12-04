package br.edu.fapi.webticket.usuario.web;

import br.edu.fapi.webticket.usuario.dao.UsuarioDAO;
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

@WebServlet(urlPatterns = "/operadorEditar")
public class OperadorEditar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idOperador = Integer.parseInt(req.getParameter("idUsuario"));

        UsuarioDAO operadorDAO = new OperadorDAOImpl();

        try{
            Usuario operador = operadorDAO.selecionarUsuario(idOperador);
            req.setAttribute("operador",operador);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/operador/editaroperador.jsp");
            requestDispatcher.forward(req, resp);
        }catch (SQLException ex){
            //TODO tratar excecao editar operador
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioDAO operadorDAO = new OperadorDAOImpl();
        Usuario operador = new Usuario();
        operador.setIdUsuario(Integer.parseInt(req.getParameter("idUsuario")));

        try {
            operador = operadorDAO.selecionarUsuario(operador.getIdUsuario());
            operador.setLogin(req.getParameter("login"));
            operador.setSenha(req.getParameter("senha"));

        if(operadorDAO.editarUsuario(operador)){
            resp.sendRedirect("/operadorController?acao=manter");
        }else{
            //TODO pagina de erro
        }
        } catch (SQLException e) {
            //TODO tratar execao
            e.printStackTrace();
        }
    }
}
