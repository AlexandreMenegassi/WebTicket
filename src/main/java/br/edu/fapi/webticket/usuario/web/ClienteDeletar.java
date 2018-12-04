package br.edu.fapi.webticket.usuario.web;

import br.edu.fapi.webticket.usuario.dao.UsuarioDAO;
import br.edu.fapi.webticket.usuario.dao.impl.ClienteDAOImpl;
import br.edu.fapi.webticket.usuario.dao.impl.OperadorDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/clienteDeletar")
public class ClienteDeletar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UsuarioDAO clienteDAO = new ClienteDAOImpl();
        int idCliente = Integer.parseInt(req.getParameter("idUsuario"));

        try{
            clienteDAO.deletarUsario(idCliente);
            resp.sendRedirect("/clienteController?acao=manter");
        }catch (SQLException ex){
            //TODO tratar exceção deletar usuario
        }

    }
}
