package br.com.fiap.dao;

import br.com.fiap.to.CadastroTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CadastroDAO {

    public ArrayList<CadastroTO> findAll(){
        ArrayList<CadastroTO> cadastros = new ArrayList<>();
        String sql = "SELECT * FROM cadastro";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if(rs != null){
                while (rs.next()){
                    CadastroTO cadastro = new CadastroTO();
                    cadastro.setCpf_cadastro(rs.getString("cpf_cadastro"));
                    cadastro.setEmail(rs.getString("email"));
                    cadastro.setStatus(rs.getString("status"));
                    cadastro.setSenha(rs.getString("senha"));
                    cadastros.add(cadastro);
                }
            }else{
                return null;
            }
        }catch (SQLException e){
            System.out.println("Erro na consulta de cadastro: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return cadastros;
    }

    public CadastroTO findByCpf(String cpf_cadastro){
        CadastroTO cadastro = new CadastroTO();
        String sql = "SELECT * FROM cadastro WHERE cpf_cadastro = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, cpf_cadastro);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
            cadastro.setCpf_cadastro(rs.getString("cpf_cadastro"));
            cadastro.setEmail(rs.getString("email"));
            cadastro.setStatus(rs.getString("status"));
            cadastro.setSenha(rs.getString("senha"));
            }else{
                return null;
            }
        }catch (SQLException e){
            System.out.println("Erro na consulta de cadastro por CPF: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return cadastro;
    }

    public CadastroTO save(CadastroTO cadastro){
        String sql = "INSERT INTO cadastro(cpf_cadastro, email, status, senha) VALUES(?, ?, ?, ?)";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, cadastro.getCpf_cadastro());
            ps.setString(2, cadastro.getEmail());
            ps.setString(3, cadastro.getStatus());
            ps.setString(4, cadastro.getSenha());
            if(ps.executeUpdate() > 0){
                return cadastro;
            }else{
                return null;
            }
        }catch (SQLException e){
            System.out.println("Erro ao inserir cadastro: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete(String cpf_cadastro){
        String sql = "DELETE FROM cadastro WHERE cpf_cadastro = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, cpf_cadastro);
            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            System.out.println("Erro ao excluír cadastro: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public CadastroTO update(CadastroTO cadastro){
        String sql = "UPDATE cadastro SET email = ?, status = ?, senha = ? WHERE cpf_cadastro = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, cadastro.getEmail());
            ps.setString(2, cadastro.getStatus());
            ps.setString(3, cadastro.getSenha());
            ps.setString(4, cadastro.getCpf_cadastro());
            if(ps.executeUpdate() > 0){
                return cadastro;
            }else{
                return null;
            }
        }catch (SQLException e){
            System.out.println("Erro ao alterar cadastro: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
}
