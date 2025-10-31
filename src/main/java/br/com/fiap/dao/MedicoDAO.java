package br.com.fiap.dao;

import br.com.fiap.to.MedicoTO;
import br.com.fiap.to.UsuarioTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedicoDAO {

    public ArrayList<MedicoTO> findAll(){
        ArrayList<MedicoTO> medicos = new ArrayList<>();
        String sql = "SELECT id_medico, nome, cpf, tipo_medico FROM medico ORDER BY id_medico";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if(rs != null){
                while (rs.next()){
                    MedicoTO medico = new MedicoTO();
                    medico.setId_medico(rs.getLong("id_medico"));
                    medico.setNome(rs.getString("nome"));
                    medico.setCpf(rs.getString("cpf"));
                    medico.setTipo_medico(rs.getString("tipo_medico"));
                    medicos.add(medico);
                }
            }else{
                return null;
            }
        }catch (SQLException e){
            System.out.println("Erro na consulta de médico" + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return medicos;
    }

    public MedicoTO findById(Long id_medico){
        MedicoTO medico = new MedicoTO();
        String sql = "SELECT * FROM medico WHERE id_medico = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id_medico);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                medico.setId_medico(rs.getLong("id_medico"));
                medico.setNome(rs.getString("nome"));
                medico.setCpf(rs.getString("cpf"));
                medico.setTipo_medico(rs.getString("tipo_medico"));
            }else{
                return null;
            }
        }catch (SQLException e){
            System.out.println("Erro na consulta de médico por ID: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return medico;
    }

    public MedicoTO save(MedicoTO medico){
        String sql = "INSERT INTO medico(nome, cpf, tipo_medico) VALUES(?, ?, ?)";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, medico.getNome());
            ps.setString(2, medico.getCpf());
            ps.setString(3, medico.getTipo_medico());
            if(ps.executeUpdate() > 0){
                return medico;
            }else{
                return null;
            }
        }catch (SQLException e){
            System.out.println("Erro ao inserir médico: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete(Long id_medico){
        String sql = "DELETE FROM medico WHERE id_medico = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id_medico);
            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            System.out.println("Erro ao excluír médico: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public MedicoTO update(MedicoTO medico){
        String sql = "UPDATE medico SET nome = ?, cpf = ?, tipo_medico = ? WHERE id_medico = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, medico.getNome());
            ps.setString(2, medico.getCpf());
            ps.setString(3, medico.getTipo_medico());
            ps.setLong(4, medico.getId_medico());
            if(ps.executeUpdate() > 0){
                return medico;
            }else{
                return null;
            }
        }catch (SQLException e){
            System.out.println("Erro ao atualizar médico: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }


}
