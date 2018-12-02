package br.edu.fapi.webticket.usuario.modelo;

public class UsuarioDetalhe {
    protected int IdUsuarioDetalhe;
    protected int IdUsuario;
    protected int IdEmpresa;
    protected String Nome;
    protected String Sobrenome;
    protected int Idade;
    protected String Sexo;
    protected String RG;
    protected String CPF;

    public int getIdUsuarioDetalhe() {
        return IdUsuarioDetalhe;
    }

    public void setIdUsuarioDetalhe(int idUsuarioDetalhe) {
        IdUsuarioDetalhe = idUsuarioDetalhe;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }

    public int getIdEmpresa() {
        return IdEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        IdEmpresa = idEmpresa;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getSobrenome() {
        return Sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        Sobrenome = sobrenome;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int idade) {
        Idade = idade;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}
