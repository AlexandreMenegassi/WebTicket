package br.edu.fapi.webticket.usuario.modelo;

public class Usuario {
	
	//Atributos
	protected int idUsario;
	protected String login;
	protected String senha;
	protected boolean admin;
	protected boolean cliente;
	protected boolean operador;
	protected int status;
	
	//GET SET
	public int getIdUsario() {
		return idUsario;
	}
	public void setIdUsario(int idUsario) {
		this.idUsario = idUsario;
	}
	public String getLogin() {
		return login;
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
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public boolean isCliente() {
		return cliente;
	}
	public void setCliente(boolean cliente) {
		this.cliente = cliente;
	}
	public boolean isOperador() {
		return operador;
	}
	public void setOperador(boolean operador) {
		this.operador = operador;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
