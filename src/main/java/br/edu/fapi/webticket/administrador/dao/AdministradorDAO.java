package br.edu.fapi.webticket.administrador.dao;

import java.util.List;

import br.edu.fapi.webticket.administrador.modelo.relatorio.RelatorioLogAcesso;

public interface AdministradorDAO {

	List<RelatorioLogAcesso> gerarRelatorioLogAcesso();
	
}
