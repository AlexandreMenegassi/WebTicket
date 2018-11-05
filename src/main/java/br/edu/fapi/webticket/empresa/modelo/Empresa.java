package br.edu.fapi.webticket.empresa.modelo;

import java.util.List;

import br.edu.fapi.webticket.cliente.modelo.Cliente;

public class Empresa {
	//Atributos
	private int id;
	private String nome;
	private String razaoSocial;
	private String cnpj;
	
	//Atributos Externos
	private List<Cliente> funcionarios;

	//GET SET
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Cliente> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Cliente> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
