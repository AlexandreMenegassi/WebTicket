package br.edu.fapi.webticket.empresa.controller;

import br.edu.fapi.webticket.empresa.dao.EmpresaDAO;
import br.edu.fapi.webticket.empresa.dao.impl.EmpresaDAOImpl;
import br.edu.fapi.webticket.empresa.modelo.Empresa;
import br.edu.fapi.webticket.usuario.dao.UsuarioDAO;
import br.edu.fapi.webticket.usuario.dao.impl.ClienteDAOImpl;
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

@WebServlet(urlPatterns = "/empresaController")
public class EmpresaController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");
        if("manter".equals(acao)) {
            List<Empresa> empresas = new ArrayList<>();
        EmpresaDAO empresaDAO = new EmpresaDAOImpl();

        empresas = empresaDAO.listarEmpresas();

        req.setAttribute("empresas",empresas);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/empresa/listarempresa.jsp");
        requestDispatcher.forward(req, resp);
    }else if("criar".equals(acao)){
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/empresa/criarempresa.jsp");
        requestDispatcher.forward(req, resp);
    }
    }
}
