package br.com.fiap.dao;

import br.com.fiap.to.UsuarioTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {

    public ArrayList<UsuarioTO> findAll(){
        ArrayList<UsuarioTO> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario ORDER BY id_usuario";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if(rs != null){
                while(rs.next()){
                    UsuarioTO usuario = new UsuarioTO();
                    usuario.setId_usuario(rs.getLong("id_usuario"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setIdade(rs.getInt("idade"));
                    usuario.setData_nascimento(rs.getDate("data_nascimento").toLocalDate());
                    usuario.setTelefone(rs.getString("telefone"));
                    usuario.setChatbot_id_conversa(rs.getInt("chatbot_id_conversa"));
                    usuario.setCadastro_cpf_cadastro(rs.getString("cadastro_cpf_cadastro"));
                    usuario.setAgenda_id_agenda(rs.getInt("agenda_id_agenda"));
                    usuario.setMedico_id_medico(rs.getInt("medico_id_medico"));
                    usuarios.add(usuario);
                }
            }else{
                return null;
            }
        }catch (SQLException e){
            System.out.println("Erro na consulta de usuário: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return usuarios;
    }

    public UsuarioTO findById(Long id_usuario){
        UsuarioTO usuario = new UsuarioTO();
        String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id_usuario);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                usuario.setId_usuario(rs.getLong("id_usuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setIdade(rs.getInt("idade"));
                usuario.setData_nascimento(rs.getDate("data_nascimento").toLocalDate());
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setChatbot_id_conversa(rs.getInt("chatbot_id_conversa"));
                usuario.setCadastro_cpf_cadastro(rs.getString("cadastro_cpf_cadastro"));
                usuario.setAgenda_id_agenda(rs.getInt("agenda_id_agenda"));
                usuario.setMedico_id_medico(rs.getInt("medico_id_medico"));
            }else{
                return null;
            }
        }catch (SQLException e){
            System.out.println("Erro na consulta de usuário por ID: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return usuario;
    }

    public UsuarioTO save(UsuarioTO usuario){
        String sql = "INSERT INTO usuario(nome, idade, data_nascimento, telefone, chatbot_id_conversa, " +
                "cadastro_cpf_cadastro, agenda_id_agenda, medico_id_medico) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, usuario.getNome());
            ps.setInt(2, usuario.getIdade());
            ps.setDate(3, Date.valueOf(usuario.getData_nascimento()));
            ps.setString(4, usuario.getTelefone());
            ps.setInt(5, usuario.getChatbot_id_conversa());
            ps.setString(6, usuario.getCadastro_cpf_cadastro());
            ps.setInt(7, usuario.getAgenda_id_agenda());
            ps.setInt(8, usuario.getMedico_id_medico());
            if(ps.executeUpdate() > 0){
                return usuario;
            }else{
                return null;
            }
        }catch (SQLException e){
            System.out.println("Erro ao inserir usuário: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete(Long id_usuario){
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id_usuario);
            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            System.out.println("Erro de exclusão do usuário: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public UsuarioTO update(UsuarioTO usuario){
        String sql = "UPDATE usuario SET nome = ?, idade = ?, data_nascimento = ?, telefone = ?," +
                "chatbot_id_conversa = ?, cadastro_cpf_cadastro = ?, agenda_id_agenda = ?, medico_id_medico = ? " + " WHERE id_usuario = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, usuario.getNome());
            ps.setInt(2, usuario.getIdade());
            ps.setDate(3, Date.valueOf(usuario.getData_nascimento()));
            ps.setString(4, usuario.getTelefone());
            ps.setInt(5, usuario.getChatbot_id_conversa());
            ps.setString(6, usuario.getCadastro_cpf_cadastro());
            ps.setInt(7, usuario.getAgenda_id_agenda());
            ps.setInt(8, usuario.getMedico_id_medico());
            ps.setLong(9, usuario.getId_usuario());
            if(ps.executeUpdate() > 0){
                return usuario;
            }else{
                return null;
            }
        }catch (SQLException e){
            System.out.println("Erro ao atualizar usuário: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
}
