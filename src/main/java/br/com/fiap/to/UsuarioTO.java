package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class UsuarioTO {
    private Long id_usuario;

    @NotBlank
    private String nome;

    @NotNull
    @Positive
    private int idade;

    @Past(message = "Data de nascimento precisa ser no passado!")
    private LocalDate data_nascimento;

    @NotNull
    private String telefone;

    @NotNull
    @Positive
    private int chatbot_id_conversa;

    @NotNull
    private String cadastro_cpf_cadastro;

    @NotNull
    @Positive
    private int agenda_id_agenda;

    @NotNull
    @Positive
    private int medico_id_medico;

    public UsuarioTO(){

    }

    public UsuarioTO(Long id_usuario, String nome, int idade, LocalDate data_nascimento, String telefone, int chatbot_id_conversa, String cadastro_cpf_cadastro, int agenda_id_agenda, int medico_id_medico) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.idade = idade;
        this.data_nascimento = data_nascimento;
        this.telefone = telefone;
        this.chatbot_id_conversa = chatbot_id_conversa;
        this.cadastro_cpf_cadastro = cadastro_cpf_cadastro;
        this.agenda_id_agenda = agenda_id_agenda;
        this.medico_id_medico = medico_id_medico;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getChatbot_id_conversa() {
        return chatbot_id_conversa;
    }

    public void setChatbot_id_conversa(int chatbot_id_conversa) {
        this.chatbot_id_conversa = chatbot_id_conversa;
    }

    public String getCadastro_cpf_cadastro() {
        return cadastro_cpf_cadastro;
    }

    public void setCadastro_cpf_cadastro(String cadastro_cpf_cadastro) {
        this.cadastro_cpf_cadastro = cadastro_cpf_cadastro;
    }

    public int getAgenda_id_agenda() {
        return agenda_id_agenda;
    }

    public void setAgenda_id_agenda(int agenda_id_agenda) {
        this.agenda_id_agenda = agenda_id_agenda;
    }

    public int getMedico_id_medico() {
        return medico_id_medico;
    }

    public void setMedico_id_medico(int medico_id_medico) {
        this.medico_id_medico = medico_id_medico;
    }
}
