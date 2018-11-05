package br.edu.fapi.webticket.topico.modelo;

import br.edu.fapi.webticket.cliente.modelo.Cliente;

public class Topico {
    //Atributos simples
    private int id;
    private String titulo;
    private String descricao;

    //Atributos compostos
    private Cliente cliente;
    private Comentario melhorResposta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
