/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corp.usuarios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

//@author pcrbrandao 
@NamedQuery(name="Usuario.listarTodos",
        query="select u from Usuario u")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@Entity
public class Usuario implements Serializable, RESTEntity {
    
    /**
     * Atributos
     */
    @Column(unique=true, nullable=false)
    private String nome;
    
    @Id @GeneratedValue
    private Long ID;
    
    @Column(nullable=false)
    private String senha;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
    
    @XmlTransient
    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }
    
    @PreUpdate
    @PrePersist
    protected void ajustarDataAtualizacao() {
        this.dataAtualizacao = new Date();
    }
    
    @XmlElement(name = "link")
    @Transient
    private Collection<Link> links;
    
    /**
     * Construtores
    */
    public Usuario(String n, String s) {
        nome = n;
        senha = s;
    }
    
    public Usuario(String n) {
        nome = n;
    }
    
    public Usuario() {
        nome = null;
        senha = null;
    }
    
    /**
     * Sets e Gets
     * @return 
     */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        String out = String.format("%s", getNome() );
        return out;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public void adicionarLink(Link link) {
         if (links == null) {
         links = new ArrayList<>();
         }
      links.add(link);
    }
    
}