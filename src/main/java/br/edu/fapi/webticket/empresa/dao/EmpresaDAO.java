package br.edu.fapi.webticket.empresa.dao;

import br.edu.fapi.webticket.empresa.modelo.Empresa;

import java.util.List;

public interface EmpresaDAO {
    List<Empresa> listarEmpresas();
    Empresa selecionarEmpresa(int id);
    Empresa selecionarEmpresa(String login);
    boolean detetarEmpresa(int id);
    boolean editarEmpresa(Empresa cliente);
}
