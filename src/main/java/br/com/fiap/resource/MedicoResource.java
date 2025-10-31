package br.com.fiap.resource;

import br.com.fiap.bo.MedicoBO;
import br.com.fiap.to.MedicoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/medico")
public class MedicoResource {
    private MedicoBO medicoBO = new MedicoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        ArrayList<MedicoTO> resultado = medicoBO.findAll();
        Response.ResponseBuilder response = null;
        if(resultado != null){
            response = Response.ok();
        }else{
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("{id_medico}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id_medico") Long id_medico){
        MedicoTO resultado = medicoBO.findById(id_medico);
        Response.ResponseBuilder response = null;
        if(resultado != null){
            response = Response.ok();
        }else{
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid MedicoTO medico){
        MedicoTO resultado = medicoBO.save(medico);
        Response.ResponseBuilder response = null;
        if(resultado != null){
            response = Response.created(null);
        }else{
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("{id_medico}")
    public Response delete(@PathParam("id_medico") Long id_medico){
        boolean resultado = medicoBO.delete(id_medico);
        Response.ResponseBuilder response = null;
        if(resultado){
            response = Response.status(204);
        }else{
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @PUT
    @Path("{id_medico}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid MedicoTO medico, @PathParam("id_medico") Long id_medico){
        medico.setId_medico(id_medico);
        MedicoTO resultado = medicoBO.update(medico);
        Response.ResponseBuilder response = null;
        if(resultado != null){
            response = Response.created(null);
        }else{
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }
}
