/**
 * Contém os campos que se referem a outras entidades.
 */
package org.receitas.enums;

/**
 *
 * @author pcrbrandao
 */
public enum Dependencia {
    
    ALIMENTO( new EntidadeEnum[] 
        {EntidadeEnum.GRUPO_ALIMENTAR}, 
            EntidadeEnum.ALIMENTO ),
    INGREDIENTE( new EntidadeEnum[] 
        {EntidadeEnum.ALIMENTO}, 
            EntidadeEnum.INGREDIENTE),
    INGREDIENTENARECEITA( new EntidadeEnum[] 
        {EntidadeEnum.RECEITA, 
        EntidadeEnum.INGREDIENTE, 
        EntidadeEnum.UNIDADE}, 
            EntidadeEnum.INGREDIENTENARECEITA);
    
    private final EntidadeEnum entidades[];
    private final EntidadeEnum nome;

    public EntidadeEnum[] getEntidades() {
        return entidades;
    }
    
    public EntidadeEnum getNome() {
        return nome;
    }
    
    private Dependencia(EntidadeEnum[] e, EntidadeEnum n) {
        entidades = e;
        nome = n;
    }

}
