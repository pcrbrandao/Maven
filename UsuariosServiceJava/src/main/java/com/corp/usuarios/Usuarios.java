/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corp.usuarios;

import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pcrbrandao
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Usuarios {
    
    @XmlElement(name = "usuario")
    private Collection<Usuario> usuarios;
    
    public Usuarios() {}
    
    public Usuarios(Collection<Usuario> u) {
        usuarios = u;
    }

    public Collection<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Collection<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
}
