/**
 * Constantes para mensagem
 */
package org.receitas.enums;

/**
 *
 * @author pcrbrandao
 */
public enum Mensagem {
    
    ERRO_PARAMETRO ("Parâmetros incorretos"),
    ERRO_EDIT("Erro ao Editar "),
    EDIT_SUCESSO ("Editado com sucesso!"),
    CREATE_SUCESSO ("Entidade criada com sucesso!"),
    CREATE_ERRO("Erro ao criar a entidade"),
    DESTROY_SUCESSO("Entidade excluída com sucesso!"),
    DESTROY_ERRO("Erro ao excluir a entidade"),
    FIND_SUCESSO("Busca retornou com sucesso!"),
    FIND_ERRO("Busca retornou erro!"),
    LISTA_VAZIA("A lista está vazia..."),
    LISTA_ERRO("Erro ao listar entidades "),
    NAO_PODE_NULL("O atributo não pode ser nulo...");
    
    
    private final String mens;
    
    private Mensagem(String m) {
        mens = m;
    }
    
    public String getMens() {
        return mens;
    }
}
