/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.controllers;

import java.util.List;
import javax.persistence.EntityManager;
import org.receitas.dominio.Usuario;
import org.receitas.JPAUtil;

/**
 *
 * @author pcrbrandao
 */
public class UsuarioControllerTest {
    
    public static void main(String args[]) {
        // EntityManager em = JPAUtil.getEm();
        // UsuarioController control = new UsuarioController(em);
        
        Usuario usuario = new Usuario();
        String ins, cam, val, op;
        ins = "select e from";
        cam = "nome";
        val = "Pedro";
        op = "like";
        
        // List<Usuario> usuarios = 
        //        control.listaEntidades(ins, usuario, cam, val, op);
        
        // for(Usuario u : usuarios)
            System.out.println(usuario.getClass().getSimpleName());
    }
}
