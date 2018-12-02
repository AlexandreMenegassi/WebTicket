package br.edu.fapi.webticket.usuario.web;

import br.edu.fapi.webticket.usuario.dao.UsuarioDAO;
import br.edu.fapi.webticket.usuario.dao.impl.UsuarioDAOImpl;
import br.edu.fapi.webticket.usuario.modelo.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/UsuarioLogar")
public class UsuarioLogar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        Usuario usuario = new Usuario();
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        usuarioDAO.fazerLogin(login,senha);


    }
}
