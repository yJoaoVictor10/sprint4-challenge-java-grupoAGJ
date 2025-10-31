package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public class MedicoTO {
    private Long id_medico;

    @NotBlank
    private String nome;

    @NotNull
    @CPF(message = "CPF inválido")
    private String cpf;

    @NotNull
    private String tipo_medico;

    public MedicoTO(){

    }

    public MedicoTO(Long id_medico, String nome, String cpf, String tipo_medico) {
        this.id_medico = id_medico;
        this.nome = nome;
        this.cpf = cpf;
        this.tipo_medico = tipo_medico;
    }

    public Long getId_medico() {
        return id_medico;
    }

    public void setId_medico(Long id_medico) {
        this.id_medico = id_medico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTipo_medico() {
        return tipo_medico;
    }

    public void setTipo_medico(String tipo_medico) {
        this.tipo_medico = tipo_medico;
    }
}
