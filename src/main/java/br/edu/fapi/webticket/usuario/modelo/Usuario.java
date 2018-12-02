package br.edu.fapi.webticket.usuario.modelo;

public class Usuario {
	
	//Atributos
	protected int idUsuario;
	protected int idUsuarioDetalhe;
	protected String login;
	protected String senha;
	protected boolean admin;
	protected boolean cliente;
	protected boolean operador;

	//GET SET
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdUsuarioDetalhe() {
		return idUsuarioDetalhe;
	}
	public void setIdUsuarioDetalhe(int idUsuarioDetalhe) {
		this.idUsuarioDetalhe = idUsuarioDetalhe;
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

}
