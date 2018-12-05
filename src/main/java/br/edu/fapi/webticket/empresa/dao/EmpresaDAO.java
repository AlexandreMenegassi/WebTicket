package br.edu.fapi.webticket.empresa.dao;

import br.edu.fapi.webticket.empresa.modelo.Empresa;

import java.util.List;

public interface EmpresaDAO {
    List<Empresa> listarEmpresas();
    Empresa selecionarEmpresa(int id);
    boolean deletarEmpresa(int id);
    boolean criarEmpresa(Empresa empresa);
    boolean editarEmpresa(Empresa empresa);
}
