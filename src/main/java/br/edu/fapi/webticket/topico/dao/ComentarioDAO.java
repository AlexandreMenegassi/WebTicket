package br.edu.fapi.webticket.topico.dao;

import br.edu.fapi.webticket.topico.modelo.Comentario;
import br.edu.fapi.webticket.topico.modelo.Topico;

import java.util.List;

public interface ComentarioDAO {
    boolean criarComentario(Comentario comentario);
    boolean detetarComentario(int idTopico);
    boolean selecionarComentario(int id);
    boolean selecionarComentario(String busca);
    boolean editarComentario(Comentario comentario);
    List<Topico> listarComentarios();
}
