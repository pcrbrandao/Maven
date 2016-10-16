/**
 * Constantes tipo String do sistema
 */
package org.receitas.enums;

/**
 *
 * @author pcrbrandao
 */
public enum Atributo {
    ENTITY_MAN("entityManager"),
    GRUPO("Grupo"),
    ID("id"),
    DESCRICAO("descricao"),
    ALIMENTO("alimento"),
    UNIDADE("unidade"),
    NOME("nome"),
    MENSAGEM("mensagem"),
    PROCEDIMENTO("procedimento"),
    ENTIDADE("entidade"),
    GET("get"),
    LISTA_ENTIDADES("listaEntidades"),
    CAMPOS("campos"),
    METODOS_GET("metodosGet"),
    NOME_ENTIDADE("nomeDaEntidade"),
    SIMBOLO("simbolo"),
    RETORNO("retorno"),
    DEPENDENCIAS("dependencias"),
    PATH_DOMINIO("org.receitas.dominio.");
    
    private final String string;
    
    private Atributo(String s) {
        string = s;
    }
    
    public String getString() {
        return string;
    }
}
