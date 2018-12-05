package br.edu.fapi.webticket.clientes.web;

import br.edu.fapi.webticket.clientes.dao.UsuariosDAO;
import br.edu.fapi.webticket.clientes.dao.impl.UsuariosDAOImpl;
import br.edu.fapi.webticket.clientes.modelo.ModeloCliente;
import br.edu.fapi.webticket.usuario.dao.UsuarioDAO;
import br.edu.fapi.webticket.usuario.dao.impl.UsuarioDAOImpl;
import br.edu.fapi.webticket.usuario.modelo.Usuario;
import br.edu.fapi.webticket.usuario.modelo.UsuarioDetalhe;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/VerificarUsuario")

public class VerificarUsuario extends HttpServlet {

    UsuariosDAOImpl userDAO = new UsuariosDAOImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ModeloCliente cliente = new ModeloCliente();

            String Nome = req.getParameter("nome");
                cliente.setNome(Nome);
            String Sobrenome = req.getParameter("sobrenome");
                cliente.setSobrenome(Sobrenome);
            String Idade = req.getParameter("idade");
                cliente.setIdade(Idade);
            String Sexo = req.getParameter("sexo");
                cliente.setSexo(Sexo);
            String RG = req.getParameter("rg");
                cliente.setRG(RG);
            String CPF = req.getParameter("cpf");
                cliente.setCPF(CPF);
            String Login = req.getParameter("login");
                cliente.setLogin(Login);
            String Senha = req.getParameter("senha");
                cliente.setSenha(Senha);

        boolean User = false;

        try {
            User = userDAO.verificarUsuario(Login);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(User){
            req.getSession().setAttribute("userDuplicado","nome de usuário já existe, por favor escolha outro");
            resp.sendRedirect("cadastrocliente.jsp");
        }
        else{
            try {
                userDAO.criarUsuarios(cliente);
                userDAO.addLoginSenha(cliente.getLogin(),cliente.getSenha());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("cadastrorealizado.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
