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

@WebServlet(urlPatterns = "/operadorDeletar")
public class OperadorDeletar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UsuarioDAO operadorDAO = new OperadorDAOImpl();
        int idOperador = Integer.parseInt(req.getParameter("idUsuario"));

        try{
            operadorDAO.deletarUsario(idOperador);
            resp.sendRedirect("/operadorController?acao=manter");
        }catch (SQLException ex){
            //TODO tratar exceção deletar usuario
        }

    }
}
