package br.edu.fapi.webticket.usuario.web;

import br.edu.fapi.webticket.usuario.dao.UsuarioDAO;
import br.edu.fapi.webticket.usuario.dao.impl.ClienteDAOImpl;
import br.edu.fapi.webticket.usuario.dao.impl.OperadorDAOImpl;
import br.edu.fapi.webticket.usuario.modelo.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/clienteCriar")
public class ClienteCriar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioDAO clienteDAO = new ClienteDAOImpl();
        Usuario cliente = new Usuario();
        cliente.setLogin(req.getParameter("login"));
        cliente.setSenha("12345");
        cliente.setIdUsuarioDetalhe(0);
        cliente.setIdEmpresa(Integer.parseInt(req.getParameter("idEmpresa")));


        try {
            clienteDAO.criarUsuario(cliente);
            resp.sendRedirect("/clienteController?acao=manter");
        }catch (SQLException ex){
            //TODO tratar o erro
        }
    }
}
