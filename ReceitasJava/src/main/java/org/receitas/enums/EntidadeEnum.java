/**
 * As entidades do domínio.
 */
package org.receitas.enums;

/**
 *
 * @author pcrbrandao
 */
public enum EntidadeEnum {
    ALIMENTO("Alimento"),
    GRUPO_ALIMENTAR("GrupoAlimentar"),
    INGREDIENTE("Ingrediente"),
    RECEITA("Receita"),
    UNIDADE("Unidade"),
    INGREDIENTENARECEITA("IngredienteNaReceita"),
    USUARIO("Usuario");
    
    private final String nome;
    
    private EntidadeEnum(String n) {
        nome = n;
    }
    
    public String getNome() {
        return nome;
    }
}
