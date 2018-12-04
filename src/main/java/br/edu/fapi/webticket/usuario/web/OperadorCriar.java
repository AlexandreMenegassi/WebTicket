package br.edu.fapi.webticket.usuario.web;

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

@WebServlet(urlPatterns = "/operadorCriar")
public class OperadorCriar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioDAO operadorDAO = new OperadorDAOImpl();
        Usuario operador = new Usuario();
        operador.setLogin(req.getParameter("login"));
        operador.setSenha(req.getParameter("senha"));


        try {
            operadorDAO.criarUsuario(operador);
            resp.sendRedirect("/operadorController?acao=manter");
        }catch (SQLException ex){
            //TODO tratar o erro
        }
    }
}
