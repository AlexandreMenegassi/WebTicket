package br.edu.fapi.webticket.ticket.modelo;


import br.edu.fapi.webticket.usuario.modelo.UsuarioDetalhe;

import java.util.Date;

public class Ticket {
    private int id;
    private String titulo;
    private String descricao;
    private Date dataCriacao;
    private Date dataFechamento;

    private UsuarioDetalhe UsuarioDetalhe;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public UsuarioDetalhe getUsuarioDetalhe() {
        return UsuarioDetalhe;
    }

    public void setUsuarioDetalhe(UsuarioDetalhe cliente) {
        this.UsuarioDetalhe = cliente;
    }
}
