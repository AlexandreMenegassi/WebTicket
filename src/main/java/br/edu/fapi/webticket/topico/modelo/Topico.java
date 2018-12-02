package br.edu.fapi.webticket.topico.modelo;

import br.edu.fapi.webticket.usuario.modelo.UsuarioDetalhe;

public class Topico {
    //Atributos simples
    private int id;
    private String titulo;
    private String descricao;

    //Atributos compostos
    private UsuarioDetalhe usuarioDetalhe;
    private Comentario melhorResposta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UsuarioDetalhe getUsuarioDetalhe() {
        return usuarioDetalhe;
    }

    public void setUsuarioDetalhe(UsuarioDetalhe UsuarioDetalhe) {
        this.usuarioDetalhe = UsuarioDetalhe;
    }

    public Comentario getMelhorResposta() {
        return melhorResposta;
    }

    public void setMelhorResposta(Comentario melhorResposta) {
        this.melhorResposta = melhorResposta;
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
}
