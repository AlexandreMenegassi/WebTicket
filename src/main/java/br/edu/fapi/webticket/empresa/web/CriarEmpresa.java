package br.edu.fapi.webticket.empresa.web;

import br.edu.fapi.webticket.empresa.dao.EmpresaDAO;
import br.edu.fapi.webticket.empresa.dao.impl.EmpresaDAOImpl;
import br.edu.fapi.webticket.empresa.modelo.Empresa;
import br.edu.fapi.webticket.usuario.dao.UsuarioDAO;
import br.edu.fapi.webticket.usuario.dao.impl.ClienteDAOImpl;
import br.edu.fapi.webticket.usuario.modelo.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/CriarEmpresa")
public class CriarEmpresa extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Empresa empresa = new Empresa();
        EmpresaDAO empresaDAO = new EmpresaDAOImpl();
        empresa.setNome(req.getParameter("Nome"));
        empresa.setRazaoSocial(req.getParameter("RazaoSocial"));
        empresa.setCnpj(req.getParameter("CNPJ"));

            empresaDAO.criarEmpresa(empresa);
            resp.sendRedirect("/empresaController?acao=manter");

    }
}