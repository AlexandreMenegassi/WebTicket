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

@WebServlet(urlPatterns = "/UsuarioLogar")
public class UsuarioLogar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        Usuario usuario = new Usuario();
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        usuario = usuarioDAO.fazerLogin(login,senha);

        if(usuario != null){
            req.getSession().setAttribute("usuario",usuario);
            if(usuario.isAdmin()){
                //TODO redirecionar para pagina do admin
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/jogo.jsp");
                requestDispatcher.forward(req, resp);
            }else if(usuario.isCliente()){
                //TODO redirecionar para pagina do cliente
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/jogo.jsp");
                requestDispatcher.forward(req, resp);
            }else if(usuario.isOperador()){
                //TODO redirecionar para pagina do operador
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/jogo.jsp");
                requestDispatcher.forward(req, resp);
            }
        }
        else{
            //TODO redirecionar para pagina de login inexistente
            resp.sendRedirect("");
        }
    }
}
