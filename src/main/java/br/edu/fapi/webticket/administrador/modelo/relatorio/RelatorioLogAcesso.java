package br.edu.fapi.webticket.administrador.modelo.relatorio;

import java.util.Date;

public class RelatorioLogAcesso {

	private int id;
	private String usuario;
	private Date dataAcesso;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Date getDataAcesso() {
		return dataAcesso;
	}
	public void setDataAcesso(Date dataAcesso) {
		this.dataAcesso = dataAcesso;
	}
	
}
