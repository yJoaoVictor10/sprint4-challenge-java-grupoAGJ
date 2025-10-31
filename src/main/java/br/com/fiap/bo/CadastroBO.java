package br.com.fiap.bo;

import br.com.fiap.dao.CadastroDAO;
import br.com.fiap.to.CadastroTO;

import java.util.ArrayList;

public class CadastroBO {
    CadastroDAO cadastroDAO;

    public ArrayList<CadastroTO> findAll(){
        cadastroDAO = new CadastroDAO();
        return cadastroDAO.findAll();
    }

    public CadastroTO findByCpf(String cpf_cadastro){
        cadastroDAO = new CadastroDAO();
        return cadastroDAO.findByCpf(cpf_cadastro);
    }

    public CadastroTO save(CadastroTO cadastro){
        cadastroDAO = new CadastroDAO();
        return cadastroDAO.save(cadastro);
    }

    public boolean delete(String cpf_cadastro){
        cadastroDAO = new CadastroDAO();
        return cadastroDAO.delete(cpf_cadastro);
    }

    public CadastroTO update(CadastroTO cadastro){
        cadastroDAO = new CadastroDAO();
        return cadastroDAO.update(cadastro);
    }
}
