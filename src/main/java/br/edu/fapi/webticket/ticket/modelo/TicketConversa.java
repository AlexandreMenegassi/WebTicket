package br.edu.fapi.webticket.ticket.modelo;

import java.sql.Timestamp;

public class TicketConversa {
    protected int idTicketConversa;
    protected int idTicket;
    protected int idUsuario;
    protected String conteudo;
    protected Timestamp dataPostagem;

    protected String usuarioNome;

    public int getIdTicketConversa() {
        return idTicketConversa;
    }

    public void setIdTicketConversa(int idTicketConversa) {
        this.idTicketConversa = idTicketConversa;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Timestamp getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(Timestamp dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }
}
