package br.com.fiap.resource;

import br.com.fiap.bo.CadastroBO;
import br.com.fiap.to.CadastroTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/cadastro")
public class CadastroResource {
    private CadastroBO cadastroBO = new CadastroBO();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        ArrayList<CadastroTO> resultado = cadastroBO.findAll();
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
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{cpf_cadastro}")
    public Response findByCpf(@PathParam("cpf_cadastro") String cpf_cadastro){
        CadastroTO resultado = cadastroBO.findByCpf(cpf_cadastro);
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
    public Response save(CadastroTO cadastro){
        CadastroTO resultado = cadastroBO.save(cadastro);
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
    @Path("/{cpf_cadastro}")
    public Response delete(@PathParam("cpf_cadastro") String cpf_cadastro){
        boolean resultado = cadastroBO.delete(cpf_cadastro);
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
    @Path("/{cpf_cadastro}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(CadastroTO cadastro, @PathParam("cpf_cadastro") String cpf_cadastro){
        cadastro.setCpf_cadastro(cpf_cadastro);
        CadastroTO resultado = cadastroBO.update(cadastro);
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
