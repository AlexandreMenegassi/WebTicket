package br.edu.fapi.webticket.empresa.dao.impl;

import br.edu.fapi.webticket.dao.MySqlConnection;
import br.edu.fapi.webticket.empresa.dao.EmpresaDAO;
import br.edu.fapi.webticket.empresa.modelo.Empresa;
import br.edu.fapi.webticket.usuario.modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAOImpl implements EmpresaDAO {
    @Override
    public List<Empresa> listarEmpresas() {
        List<Empresa> empresas = new ArrayList<>();
        try (Connection connection = MySqlConnection.abrirConexao()) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from empresa", Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Empresa empresa = new Empresa();
                empresa.setId(resultSet.getInt("IdEmpresa"));
                empresa.setNome(resultSet.getString("Nome"));
                empresa.setRazaoSocial(resultSet.getString("RazaoSocial"));
                empresa.setCnpj(resultSet.getString("CNPJ"));

                empresas.add(empresa);
            }

            return empresas;
        } catch (SQLException e) {
            System.out.println("Conexão não estabelecida.");
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean deletarEmpresa(int id) {
        try (Connection connection = MySqlConnection.abrirConexao()) {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from empresa where IdEmpresa = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Conexão não estabelecida.");
            System.out.println(e);
            return false;
        }
    }

    public boolean criarEmpresa(Empresa empresa){
        try (Connection connection = MySqlConnection.abrirConexao()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO empresa ( Nome, RazaoSocial, CNPJ) values(?,?,?)");
            preparedStatement.setString(1, empresa.getNome());
            preparedStatement.setString(2, empresa.getRazaoSocial());
            preparedStatement.setString(3, empresa.getCnpj());
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Conexão não estabelecida.");
            System.out.println(e);
            return false;
        }
    }
    @Override
    public boolean editarEmpresa(Empresa empresa) {
        try(Connection connection = MySqlConnection.abrirConexao()){
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet resultSet = statement.executeQuery("select * from empresa where idEmpresa = " + empresa.getId());

            if (resultSet.first()) {
                resultSet.updateString("Nome", empresa.getNome());
                resultSet.updateString("RazaoSocial", empresa.getRazaoSocial());
                resultSet.updateString("CNPJ", empresa.getCnpj());
                resultSet.updateRow();
                return resultSet.rowUpdated();
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public Empresa selecionarEmpresa(int id) {
        Empresa empresa = null;
        try (Connection connection = MySqlConnection.abrirConexao()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from empresa where IdEmpresa = ?",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.first()) {
                empresa = new Empresa();
                empresa.setId(resultSet.getInt("IdEmpresa"));
                empresa.setNome(resultSet.getString("Nome"));
                empresa.setCnpj(resultSet.getString("CNPJ"));
                empresa.setRazaoSocial(resultSet.getString("RazaoSocial"));
                connection.close();
                return empresa;
            }
        } catch (SQLException e) {
            System.out.println("Conexão não estabelecida.");
            System.out.println(e.getMessage());
        }
        return empresa;
    }
}
