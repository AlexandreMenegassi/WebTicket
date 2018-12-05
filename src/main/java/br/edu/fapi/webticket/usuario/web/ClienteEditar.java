package br.edu.fapi.webticket.usuario.web;

import br.edu.fapi.webticket.empresa.dao.EmpresaDAO;
import br.edu.fapi.webticket.empresa.dao.impl.EmpresaDAOImpl;
import br.edu.fapi.webticket.empresa.modelo.Empresa;
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

@WebServlet(urlPatterns = "/clienteEditar")
public class ClienteEditar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idOperador = Integer.parseInt(req.getParameter("idUsuario"));

        UsuarioDAO clienteDAO = new ClienteDAOImpl();

        try{
            Usuario cliente = clienteDAO.selecionarUsuario(idOperador);
            req.setAttribute("cliente",cliente);

            List<Empresa> empresas = new ArrayList<>();
            EmpresaDAO empresaDAO = new EmpresaDAOImpl();
            empresas = empresaDAO.listarEmpresas();
            req.setAttribute("empresas",empresas);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/cliente/editarcliente.jsp");
            requestDispatcher.forward(req, resp);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioDAO clienteDAO = new ClienteDAOImpl();
        Usuario cliente = new Usuario();
        cliente.setIdUsuario(Integer.parseInt(req.getParameter("idUsuario")));

        try {
            cliente = clienteDAO.selecionarUsuario(cliente.getIdUsuario());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            cliente.setLogin(req.getParameter("login"));
            cliente.setSenha(req.getParameter("senha"));

            clienteDAO.editarUsuario(cliente);
            resp.sendRedirect("/clienteController?acao=manter");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
