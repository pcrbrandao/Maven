/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corp.usuarios;

import java.util.List;

/**
 *
 * @author pcrbrandao
 * @param <E>
 */
public interface interfaceDAO< E > {
    
    public void criar(E obj);
    public void excluir(E obj, E id);
    public void editar(E obj, E id);
    public E busca(E obj, E id);
    public List<E> lista(E obj);
    
}
