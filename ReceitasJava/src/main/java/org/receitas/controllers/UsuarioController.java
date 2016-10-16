/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.controllers;

import org.receitas.interfaces.EntidadeController;
import java.util.List;
import javax.persistence.EntityManager;
import org.receitas.dominio.Usuario;

/**
 *
 * @author pcrbrandao
 */
public class UsuarioController extends EntidadeController {

    public UsuarioController(EntityManager em) {
        super(em);
    }
    
    public Usuario buscaPorNome(String n) {
        
        Usuario usuario = new Usuario();
        List<Usuario> usuarioList = listaEntidades(usuario, "nome", n, "=");
        if(usuarioList.isEmpty()) {
            usuario = null;
        } else {
            usuario = usuarioList.get(0);
        }
        return usuario;
    }
    
    public List<Usuario> listaUsuarios(String q) {
        
        // Query query = getEntityManager().createNamedQuery(q, Usuario.class);
        List<Usuario> usuarios = listaEntidades(q);
        
        return usuarios;
    }
}
