package br.edu.fapi.webticket.empresa.web;



import br.edu.fapi.webticket.empresa.dao.EmpresaDAO;
import br.edu.fapi.webticket.empresa.dao.impl.EmpresaDAOImpl;
import br.edu.fapi.webticket.empresa.modelo.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/EditarEmpresa")
public class EditarEmpresa extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idEmpresa = Integer.parseInt(req.getParameter("idEmpresa"));

        EmpresaDAO empresaDAO = new EmpresaDAOImpl();

            Empresa empresa = empresaDAO.selecionarEmpresa(idEmpresa);
            req.setAttribute("empresa",empresa);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/empresa/editarempresa.jsp");
            requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmpresaDAO empresaDAO = new EmpresaDAOImpl();
        Empresa empresa = new Empresa();
        empresa.setId(Integer.parseInt(req.getParameter("idEmpresa")));

            empresa = empresaDAO.selecionarEmpresa(empresa.getId());

            empresa.setRazaoSocial(req.getParameter("idEmpresa"));
            empresa.setRazaoSocial(req.getParameter("RazaoSocial"));
            empresa.setNome(req.getParameter("Nome"));
            empresa.setCnpj(req.getParameter("CNPJ"));

            empresaDAO.editarEmpresa(empresa);
            resp.sendRedirect("/empresaController?acao=manter");
            //TODO pagina de err
    }
}

