package br.edu.fapi.webticket.empresa.web;

import br.edu.fapi.webticket.empresa.dao.EmpresaDAO;
import br.edu.fapi.webticket.empresa.dao.impl.EmpresaDAOImpl;
import br.edu.fapi.webticket.usuario.dao.UsuarioDAO;
import br.edu.fapi.webticket.usuario.dao.impl.ClienteDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/DeletarEmpresa")
public class DeletarEmpresa extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EmpresaDAO empresaDAO = new EmpresaDAOImpl();
        int idEmpresa = Integer.parseInt(req.getParameter("idEmpresa"));


            empresaDAO.deletarEmpresa(idEmpresa);
            resp.sendRedirect("/empresaController?acao=manter");


    }
}