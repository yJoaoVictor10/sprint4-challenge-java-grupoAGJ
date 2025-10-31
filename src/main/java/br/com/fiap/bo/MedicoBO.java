package br.com.fiap.bo;

import br.com.fiap.dao.MedicoDAO;
import br.com.fiap.to.MedicoTO;

import java.util.ArrayList;

public class MedicoBO {
    private MedicoDAO medicoDAO;

    public ArrayList<MedicoTO> findAll(){
        medicoDAO = new MedicoDAO();
        return medicoDAO.findAll();
    }

    public MedicoTO findById(Long id_medico){
       medicoDAO = new MedicoDAO();
       return medicoDAO.findById(id_medico);
    }

    public MedicoTO save(MedicoTO medico){
        medicoDAO = new MedicoDAO();
        return medicoDAO.save(medico);
    }

    public boolean delete(Long id_medico){
        medicoDAO = new MedicoDAO();
        return medicoDAO.delete(id_medico);
    }

    public MedicoTO update(MedicoTO medico){
        medicoDAO = new MedicoDAO();
        return medicoDAO.update(medico);
    }
}
