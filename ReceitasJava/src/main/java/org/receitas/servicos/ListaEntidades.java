package org.receitas.servicos;

import org.receitas.interfaces.ComandoRequest;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.receitas.enums.Arquivo;
import org.receitas.enums.Atributo;
import org.receitas.enums.Mensagem;

/**
 * Essa classe faz uma busca pelos campos e métodos da entidade
 * buscando os métodos get e retornando-os para que o jsp
 * invoque esses métodos pois os campos da entidade são private
 * e não ficam disponíveis para acesso direto
 * A idéia é listar os campos automaticamente sem precisar saber
 * quem são eles.
 * @author pcrbrandao
 */
public class ListaEntidades< E > extends ComandoRequest {
    
    private Field[] campos;
    private Method[] metodos;
    private List<Method> metodosGet;
    private E entidade;
    private List<E> entidades;
    private Class classe;
    private String campoNome, methodName, nomeDaEntidade;
    
    public ListaEntidades() {
        metodosGet = new ArrayList<>();
        entidades = new ArrayList<>();
    }
    
    private void ObterMetodos() {
        
        setCampos(getClasse().getDeclaredFields());
        setMetodos(getClasse().getMethods());
            
        /**
        * Faz a busca por métodos get para os campos.
        */
        for(Field f : getCampos()) {
            setCampoNome(Atributo.GET.getString() + f.getName());
            for(Method m : getMetodos()) {
                setMethodName(m.getName());
                if(getMethodName().compareToIgnoreCase(getCampoNome())==0)
                    getMetodosGet().add(m);
                }   
            }
    }
    
    private void RetornaAtributos(HttpServletRequest req) {
        
        setNomeDaEntidade(req.getParameter(Atributo.ENTIDADE.getString()));
        // Essa é a lista das entidades
        req.setAttribute(Atributo.LISTA_ENTIDADES.getString(), getEntidades());
        // Campos que a entidade possui. Admitindo que são todos listáveis
        req.setAttribute(Atributo.CAMPOS.getString(), getCampos());
        // Metodos get para os campos são necessários porque os campos private
        // não são acessíveis diretamente
        req.setAttribute(Atributo.METODOS_GET.getString(), getMetodosGet());
        req.setAttribute(Atributo.ENTIDADE.getString(), getEntidade());
        req.setAttribute(Atributo.NOME_ENTIDADE.getString(), getNomeDaEntidade());
    }

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
        
        setEntidade((E)criarEntidade(req));
        
        ObterMetodos();
        
        try {
            setEntidades( obtemLista(req, getEntidade()));
        
            if(getEntidades().isEmpty())
                throw new Exception(Mensagem.LISTA_VAZIA.getMens());
        } catch (Exception e) {
            setAttributeMensagem(req, Mensagem.LISTA_ERRO, e);
            return Arquivo.RESULT.getArquivoFull();
        }
        
        RetornaAtributos(req);
        
        return Arquivo.LISTA_ENTIDADE.getArquivoFull();
    }

    public Field[] getCampos() {
        return campos;
    }

    public void setCampos(Field[] campos) {
        this.campos = campos;
    }

    public Method[] getMetodos() {
        return metodos;
    }

    public void setMetodos(Method[] metodos) {
        this.metodos = metodos;
    }

    public E getEntidade() {
        return entidade;
    }

    public void setEntidade(E entidade) {
        this.entidade = entidade;
    }

    public List<E> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<E> entidades) {
        this.entidades = entidades;
    }

    public Class getClasse() {
        if(classe == null) {
            setClasse(getEntidade());
        }
        return classe;
    }

    public void setClasse(E ent) {
        classe = ent.getClass();
    }
    
    public void setClasse(Class c) {
        classe = c;
    }

    public String getCampoNome() {
        return campoNome;
    }

    public void setCampoNome(String campoNome) {
        this.campoNome = campoNome;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getNomeDaEntidade() {
        return nomeDaEntidade;
    }

    public void setNomeDaEntidade(String nomeDaEntidade) {
        this.nomeDaEntidade = nomeDaEntidade;
    }

    public List<Method> getMetodosGet() {
        return metodosGet;
    }

    public void setMetodosGet(List<Method> metodosGet) {
        this.metodosGet = metodosGet;
    }
}
