package br.edu.fapi.webticket.usuario.modelo;

public class Usuario {
	
	//Atributos
	protected int idUsario;
	protected String login;
	protected String senha;
	protected int nivelAcesso;
	protected int status;
	
	//GET SET
	
	public String getLogin() {
		return login;
	}
	public int getIdUsario() {
		return idUsario;
	}
	public void setIdUsario(int idUsario) {
		this.idUsario = idUsario;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getNivelAcesso() {
		return nivelAcesso;
	}
	public void setNivelAcesso(int nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
