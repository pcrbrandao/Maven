/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.servicos;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.receitas.dominio.Alimento;
import org.receitas.dominio.IngredienteNaReceita;
import org.receitas.enums.Mensagem;
import org.receitas.interfaces.Ler;
import org.receitas.interfaces.Preenche;

/**
 *
 * @author pcrbrandao
 */
public class LerAlimento extends Ler implements Preenche {
    
    private final Alimento a;

    public LerAlimento() {
        this.a = new Alimento();
    }

    @Override
    public < E > E preenche(HttpServletRequest req) {
        
        List<IngredienteNaReceita> receitaIngredientes = new ArrayList<>();
        String recId = req.getParameter("receitaId");
        IngredienteNaReceita ri = new IngredienteNaReceita();
        
        try {
            receitaIngredientes = (obtemLista(req, ri,
                    "receitaId", recId, "=" ));
        } catch (Exception e ) {
            setAttributeMensagem(req, Mensagem.LISTA_ERRO, e);
            return null;
        }
        
        return (E) setEntidadeId(a, req);
    }
}
