package br.edu.fapi.webticket.administrador.dao.impl;

import java.util.Date;
import java.util.List;

import br.edu.fapi.webticket.administrador.dao.AdministradorDAO;
import br.edu.fapi.webticket.administrador.modelo.relatorio.RelatorioLogAcesso;

public class AdministradorDAOImpl implements AdministradorDAO {

	public List<RelatorioLogAcesso> gerarRelatorioLogAcesso() {
		//TODO: Remover quando a base de dados estiver finalizada.
		RelatorioLogAcesso log1 = new RelatorioLogAcesso();
		log1.setId(1);
		log1.setUsuario("Teste");
		log1.setDataAcesso(new Date());
		
		RelatorioLogAcesso log2 = new RelatorioLogAcesso();
		log2.setId(2);
		log2.setUsuario("Teste");
		log2.setDataAcesso(new Date());
		
		RelatorioLogAcesso log3 = new RelatorioLogAcesso();
		log3.setId(3);
		log3.setUsuario("Teste");
		log3.setDataAcesso(new Date());
		
		List<RelatorioLogAcesso> listaAcessos = new ArrayList<RelatorioLogAcesso>();
		listaAcessos.add(log1);
		listaAcessos.add(log2);
		listaAcessos.add(log2);
		
		return gerarRelatorioLogAcesso();
		
	}

}
