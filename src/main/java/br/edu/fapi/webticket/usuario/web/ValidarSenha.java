package br.edu.fapi.webticket.usuario.web;

import br.edu.fapi.webticket.usuario.dao.UsuarioDAO;
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

@WebServlet(urlPatterns = "/alterarSenha")
public class ValidarSenha extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String senha1 = req.getParameter("senha1");
        String senha2 = req.getParameter("senha2");
        int i = 1;
        int idUsuario = Integer.parseInt(req.getParameter("idUsuario"));

        if(senha1.equals(senha2)){
            UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
            try {
                Usuario usuario = usuarioDAO.selecionarUsuario(idUsuario);
                usuario.setSenha(senha1);
                usuario.setIdUsuarioDetalhe(i);
                usuarioDAO.editarUsuario(usuario);
                req.getSession().setAttribute("usuario",usuario);
                resp.sendRedirect("/controller?acao=home");

            } catch (SQLException e) {
                e.printStackTrace();
            }


        }else{
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/usuarios/alterarSenha.jsp");
            requestDispatcher.forward(req, resp);
        }

    }
}
