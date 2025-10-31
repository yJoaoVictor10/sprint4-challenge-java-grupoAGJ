package br.com.fiap.to;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public class CadastroTO {

    @NotNull
    @CPF(message = "CPF inválido")
    private String cpf_cadastro;

    @Email(message = "E-mail inválido")
    private String email;

    @NotNull
    private String status;

    @NotNull
    private String senha;

    public CadastroTO(){

    }

    public CadastroTO(String cpf_cadastro, String email, String status, String senha) {
        this.cpf_cadastro = cpf_cadastro;
        this.email = email;
        this.status = status;
        this.senha = senha;
    }

    public String getCpf_cadastro() {
        return cpf_cadastro;
    }

    public void setCpf_cadastro(String cpf_cadastro) {
        this.cpf_cadastro = cpf_cadastro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
