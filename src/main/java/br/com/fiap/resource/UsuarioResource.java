package br.com.fiap.resource;

import br.com.fiap.bo.UsuarioBO;
import br.com.fiap.to.UsuarioTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/usuario")
public class UsuarioResource {
    private UsuarioBO usuarioBO = new UsuarioBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        ArrayList<UsuarioTO> resultado = usuarioBO.findAll();
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
    @Path("/{id_usuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id_usuario") Long id_usuario){
        UsuarioTO resultado = usuarioBO.findById(id_usuario);
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
    public Response save(@Valid UsuarioTO usuario){
        UsuarioTO resultado = usuarioBO.save(usuario);
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
    @Path("/{id_usuario}")
    public Response delete(@PathParam("id_usuario") Long id_usuario){
        boolean resultado = usuarioBO.delete(id_usuario);
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
    @Path("{id_usuario}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid UsuarioTO usuario, @PathParam("id_usuario") Long id_usuario){
        usuario.setId_usuario(id_usuario);
        UsuarioTO resultado = usuarioBO.update(usuario);
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
