/*
* as entidades ComandoRequest serão utilizadas no servlet
* para o processamento polimófico
*/
package org.receitas.interfaces;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.receitas.JPAUtil;
import org.receitas.enums.Atributo;
import org.receitas.enums.Dependencia;
import org.receitas.enums.EntidadeEnum;
import org.receitas.enums.Mensagem;

/**
 * @author pcrbrandao
 */
public abstract class ComandoRequest< E > {
    
    public abstract String executa(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException;
    
    public void setAttributeMensagem(HttpServletRequest req, Mensagem m) {
        req.setAttribute(Atributo.MENSAGEM.getString(), m.getMens());
    }
    
    public void setAttributeMensagem(HttpServletRequest req, Mensagem m, Exception e) {
        System.out.printf("%s: %s", Mensagem.ERRO_EDIT.getMens(), e);
        req.setAttribute(Atributo.MENSAGEM.getString(), 
                String.format("%s: %s", m.getMens(), e.getMessage()) );
    }
    
    /**
     * Obtém o id String do request que é o ListaEntidade.jsp,
     * atribui para o id da ent e retorna a entidade preenchida.
     * @param ent
     * @param req
     * @return
     */
    public Entidade setEntidadeId( Entidade ent, HttpServletRequest req ) {
        
        ent.setId(Long.parseLong(req.getParameter(Atributo.ID.getString())));
        
        if(ent.getId()==null)
            ent = null;
        
        return ent;
    }
     
    public E criarEntidade(HttpServletRequest req) {
         
        String nome = req.getParameter(Atributo.ENTIDADE.getString());
        
        return criarEntidade(nome, req);
    }
    
    public E criarEntidade(EntidadeEnum e, HttpServletRequest req) {
        
        return criarEntidade(e.getNome(), req);
    }
    
    public E criarEntidade(String nome, HttpServletRequest req) {
        
        String nomeDaClasse;
        E entidade;
        Class classe;
        
        nomeDaClasse = Atributo.PATH_DOMINIO.getString() + nome;
        // entidade = new Entidade();
         
        try {
            classe = Class.forName(nomeDaClasse);
            entidade = (E)classe.newInstance();
            return entidade;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            setAttributeMensagem(req, Mensagem.LISTA_ERRO, e);
            entidade = null;
        }
        return entidade;
    }
    
    public List<E> obtemLista(HttpServletRequest req, E ent) {
        
        try {
            EntityManager emg = (EntityManager)req.getAttribute(Atributo.ENTITY_MAN.getString());
            if(!emg.isOpen())
                emg = JPAUtil.getEm();
            EntidadeController controller = new EntidadeController(emg);
            /**
             * o método listaEntidades com somente a entidade
             * retorna uma lista com todas as entidades
             * existe um método sobreposto que permite uma consulta jsql.
             * */
            
            List<E> e;
            e = controller.listaEntidades(ent);
            
            return e;
            
        } catch (Exception e ) {
            setAttributeMensagem(req, Mensagem.LISTA_ERRO, e);
            return null;
        }
    }
    
    public List<E> obtemLista(HttpServletRequest req, E ent, String campo,
            String valor, String oper) {
        
        try {
            EntityManager emg = (EntityManager)req.getAttribute(Atributo.ENTITY_MAN.getString());
            if(!emg.isOpen())
                emg = JPAUtil.getEm();
            EntidadeController controller = new EntidadeController(emg);
            
            List<E> e = new ArrayList<>();
            e = controller.listaEntidades(ent, campo, valor,  oper);
            
            return e;
        } catch (Exception e) {
            setAttributeMensagem(req, Mensagem.LISTA_ERRO, e);
            return null;
        }
    }
    
    public Entidade buscaEntidade(Entidade ent, HttpServletRequest req) {
        
        Entidade entExist = new Entidade();
        EntityManager emg = (EntityManager)req.getAttribute(Atributo.ENTITY_MAN.getString());
        if(!emg.isOpen())
            emg = JPAUtil.getEm();
        
        EntidadeController control = new EntidadeController(emg);
        try {
            entExist = control.findEntidade(ent.getId(), ent);
            setAttributeMensagem(req, Mensagem.FIND_SUCESSO);
            
            return entExist;    
        } catch (Exception e) {
            setAttributeMensagem(req, Mensagem.FIND_ERRO, e);
            return null;
        }
    }
    
    public < E > E buscaObjeto(E ent, HttpServletRequest req, E id) {
        
        EntityManager emg = (EntityManager)req.getAttribute(Atributo.ENTITY_MAN.getString());
        if(!emg.isOpen())
            emg = JPAUtil.getEm();
        
        EntidadeController control = new EntidadeController(emg);
        try {
            ent = control.find(id, ent);
            setAttributeMensagem(req, Mensagem.FIND_SUCESSO);
            return ent;
        } catch (Exception e) {
            setAttributeMensagem(req, Mensagem.FIND_ERRO, e);
            return null;
        }
    }
    
    public Map<String,List< E >> obterDependencias( HttpServletRequest req ) {
        
        List<E> ents = new ArrayList<>();
        Map<String,List<E>> dMap = new HashMap<>();
        
        String entNome = req.getParameter(Atributo.ENTIDADE.getString());

            // Class classe = Class.forName(entNome);
            // Object ent = (Object) classe.newInstance();
            Object ent = criarEntidade(entNome, req);
            
        // faz a busca pela dependencia e obtem o array
        for(Dependencia d : Dependencia.values())
            if(ent.getClass().getSimpleName().equals(d.getNome().getNome())) {
                for(EntidadeEnum de : d.getEntidades()) {
                    try {
                        ents = obtemLista(req, criarEntidade(de,req));
                        if(ents.isEmpty())
                            throw new Exception(Mensagem.LISTA_VAZIA.getMens());
                
                        dMap.put(de.getNome(), ents);
                    } catch (Exception e) {
                        setAttributeMensagem(req, Mensagem.LISTA_ERRO, e);
                    }
                }
            }
        return dMap;
    }
    
    public Map<String,List< E >> obterDependencias( E ent, HttpServletRequest req ) {
        
        List<E> ents = new ArrayList<>();
        Map<String,List<E>> dMap = new HashMap<>();
            
        // faz a busca pela dependencia e obtem o array
        for(Dependencia d : Dependencia.values())
            if(ent.getClass().getSimpleName().equals(d.getNome().getNome())) {
                for(EntidadeEnum de : d.getEntidades()) {
                    try {
                        ents = obtemLista(req, criarEntidade(de,req));
                        if(ents.isEmpty())
                            throw new Exception(Mensagem.LISTA_VAZIA.getMens());
                
                        dMap.put(de.getNome(), ents);
                    } catch (Exception e) {
                        setAttributeMensagem(req, Mensagem.LISTA_ERRO, e);
                    }
                }
            }
        return dMap;
    }    
    
}
