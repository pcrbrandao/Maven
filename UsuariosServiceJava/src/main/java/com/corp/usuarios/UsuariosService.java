/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corp.usuarios;

import java.net.URI;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author pcrbrandao
 */
@Path("")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuariosService {
    
    /**
     * Funções
     * @return  
     */
    @GET
    @Path("/listarusuarios")
    public Usuarios listarUsuarios() {
        
        UsuarioDAO dao = new UsuarioDAO();
        Usuarios usuarios = new Usuarios();
        
        List<Usuario> lista = dao.lista(new Usuario());
        usuarios.setUsuarios(lista);
        
        return usuarios;
    }
    
    @GET
    @Path("/encontraid")
    public Response encontra(@QueryParam("id") Long id, 
            @HeaderParam("If-Modified-Since") Date modifiedSince) {
        
        UsuarioDAO dao = new UsuarioDAO();
        Usuario u = (Usuario)dao.busca(new Usuario(), id);
        
        if (u != null) {
            if (modifiedSince == null || 
                    (modifiedSince != null && u.getDataAtualizacao()
                    .after(modifiedSince))) {
                return Response.ok(u).build();
            }
            return Response.notModified().build();
        }
        return Response.status(javax.ws.rs.core.Response.Status.NOT_FOUND).build();
    }
    
    @POST
    @Path("/encontranome")
    public Response encontraNome(Usuario usuario) {
        
        UsuarioDAO dao = new UsuarioDAO();
        Usuario u = (Usuario)dao.buscaPorNome(usuario.getNome());
        
        if (u != null) {
            u.setSenha(null);
            return Response.ok(u).build();
        } else {
            return Response.status(javax.ws.rs.core.Response.Status.NOT_FOUND).build();
        }
    }
  
    @POST
    @Path("/autenticar")
    public Response autenticarServ(Usuario usuario) {
        
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuarioExistente = new Usuario();
        try {
            usuarioExistente = dao.buscaPorNome(usuario.getNome());
            if (usuarioExistente != null) {
                if (usuario.getSenha().equals(usuarioExistente.getSenha()) ) {
                    return Response.ok(usuarioExistente).build();
                } else {
                    return Response.status(javax.ws.rs.core.Response.Status.NOT_FOUND).build();
                }
            } else {
                return Response.status(javax.ws.rs.core.Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            System.out.printf("Erro autenticando usuario: %s", e);
            return Response.status(javax.ws.rs.core.Response.Status.NOT_ACCEPTABLE).build();
        }
    }
    
    @POST
    @Path("/criar")
    public Response criarUsuario(@Context UriInfo uriInfo, 
            Usuario u) {
        
        if(u.getNome()!=null && u.getSenha()!=null) {
            ObjetoDAO dao = new ObjetoDAO();
            dao.criar(u);
            
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            URI location = uriBuilder.path("/encontraid/{id}")
                    .build(u.getID());
            
            return Response.created(location).build();
        } else {
            return Response.serverError().build();
        }
    }
    
    @DELETE
    @Path("/delete")
    public Response delete(@QueryParam("ID") Long id) {
        
        Usuario u = new Usuario();
        ObjetoDAO dao = new ObjetoDAO();
        try {
            System.out.printf("Tentando excluir ID: %d", id);
            u = (Usuario)dao.busca(new Usuario(), id);
            dao.excluir(u, u.getID());
            return Response.ok().build();
        } catch (Exception e) {
            System.out.printf("Erro tentando excluir: %s", e);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @POST
    @Path("/update")
    public Response update(Usuario u) {
        
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuarioExist = new Usuario();
        
        try {
            usuarioExist = (Usuario)dao.busca(u, u.getID());
            usuarioExist.setNome(u.getNome());
            usuarioExist.setSenha(u.getSenha());
            
            dao.editar(usuarioExist, usuarioExist.getID());
            System.out.printf("Objeto em POST update %s", u);
            
            return Response.accepted().build();
        } catch (Exception e) {
            System.out.printf("Erro tentando editar: %s", e);
            return Response.serverError().build();
        }
    }
}
