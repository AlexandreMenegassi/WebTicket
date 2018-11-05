package br.edu.fapi.webticket.administrador.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fapi.webticket.administrador.dao.AdministradorDAO;
import br.edu.fapi.webticket.administrador.dao.impl.AdministradorDAOImpl;
import br.edu.fapi.webticket.administrador.modelo.relatorio.RelatorioLogAcesso;

@WebServlet(urlPatterns="/ControllerAdmin")
public class AdministradorServlet extends HttpServlet {

	private AdministradorDAO administradorDAO;
	
	//private OperadorDAO operadorDAO;
	
	public AdministradorServlet() {
		administradorDAO = new AdministradorDAOImpl();
		//operadorDAO = new OperadorDAOImpl();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");
		if("relatorioLog".equalsIgnoreCase(acao)){
			List<RelatorioLogAcesso> registrosLog = administradorDAO.gerarRelatorioLogAcesso();
			req.setAttribute("registrosLog", registrosLog);
			req.getRequestDispatcher("/WEB-INF/admin/relatorios/relatorio-log.jsp").forward(req, resp);
		}else if("relatorioErrosLogin".equalsIgnoreCase(acao)) {
			
		}
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
