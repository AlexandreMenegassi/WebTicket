package br.edu.fapi.webticket.ticket.modelo;

import java.sql.Timestamp;

public class TicketConversa {
    protected int IdTicketConversa;
    protected int IdTicket;
    protected int IdUsuario;
    protected String Conteudo;
    protected Timestamp DataPostagem;

    protected String usuarioNome;

    public int getIdTicketConversa() {
        return IdTicketConversa;
    }

    public void setIdTicketConversa(int idTicketConversa) {
        IdTicketConversa = idTicketConversa;
    }

    public int getIdTicket() {
        return IdTicket;
    }

    public void setIdTicket(int idTicket) {
        IdTicket = idTicket;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getConteudo() {
        return Conteudo;
    }

    public void setConteudo(String conteudo) {
        Conteudo = conteudo;
    }

    public Timestamp getDataPostagem() {
        return DataPostagem;
    }

    public void setDataPostagem(Timestamp dataPostagem) {
        DataPostagem = dataPostagem;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }
}
