/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corp.usuarios;

/**
 *
 * @author pcrbrandao
 */
public class UsuarioDAO extends ObjetoDAO {
    
    public Usuario buscaPorNome (String nome) {
        
        String jpql = "select u from Usuario u where nome = :nome";
        
        return (Usuario)buscaCampo(new Usuario(),jpql, "nome", nome);
    }
    
    public boolean usuarioExiste (String nome) {
        Usuario u = buscaPorNome(nome);
        if(u != null) {
            return true;
        } else {
            return false;
        }
    }
}
