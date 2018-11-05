package br.edu.fapi.webticket.topico.dao;

import br.edu.fapi.webticket.topico.modelo.Topico;

import java.util.List;

public interface TopicoDAO {
    boolean criarTopico(Topico topico);
    boolean detetarTopico(int idTopico);
    boolean selecionarTopico(int id);
    boolean selecionarTopico(String busca);
    boolean editarTopico(Topico topico);
    List<Topico> listarTopicos();
}
