/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.servicos;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.receitas.dominio.IngredienteNaReceita;
import org.receitas.enums.Arquivo;
import org.receitas.enums.Atributo;
import org.receitas.enums.Mensagem;
import org.receitas.interfaces.Entidade;
import org.receitas.interfaces.Ler;
import org.receitas.interfaces.Preenche;

/**
 *
 * @author pcrbrandao
 */
public class LerIngredienteNaReceita extends Ler implements Preenche {
    
    private IngredienteNaReceita inNaRec;
    private IngredienteNaReceitaPK inNaRecPK;
    
    public LerIngredienteNaReceita() {}
    
    public LerIngredienteNaReceita(IngredienteNaReceitaPK inPK) {
        
        inNaRec = new IngredienteNaReceita(inPK);
        inNaRecPK = inPK;
    }
    
    public LerIngredienteNaReceita(Long recId, Long ingId) {
        
        inNaRec = new IngredienteNaReceita(recId, ingId);
        inNaRecPK = new IngredienteNaReceitaPK(recId, ingId);
    }

    @Override
    public <E> E preenche(HttpServletRequest req) {
        
        Long receitaId = Long.parseLong(req.getParameter("receitaId"));
        Long ingredienteId = Long.parseLong(req.getParameter("ingredienteId"));
        
        if(receitaId<=0 || ingredienteId<= 0) {
            inNaRec = null;
        } else {
            setInNaRecPK(receitaId, ingredienteId);
            setInNaRec(getInNaRecPK());
        }
        
        return (E)getInNaRec();
    }
    
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        setInNaRec((IngredienteNaReceita)preenche(req));
        setInNaRecPK(getInNaRec().getReceitaId(), 
                getInNaRec().getIngredienteId());
        
        if(getInNaRec() == null) {
            setAttributeMensagem(req, Mensagem.ERRO_PARAMETRO);
        } else {
            setInNaRec( 
                    (IngredienteNaReceita)
                            buscaObjeto( getInNaRec(), req, getInNaRecPK() ) 
            );
            req.setAttribute("ingredienteNaReceita", getInNaRec());
            
            Map<String,List<Entidade>> map = new HashMap<>();
            map = obterDependencias(req);
            req.setAttribute(Atributo.DEPENDENCIAS.getString(), map);
        }
        return String.format("%s%s.jsp", 
                Arquivo.EDITAR.getArquivoFull(),
                "IngredienteNaReceita");
    }

    public IngredienteNaReceita getInNaRec() {
        return inNaRec;
    }

    public void setInNaRec(IngredienteNaReceita inNaRec) {
        this.inNaRec = inNaRec;
    }
    
    public void setInNaRec(IngredienteNaReceitaPK inNaRecPK) {
        inNaRec = new IngredienteNaReceita(inNaRecPK);
    }

    public IngredienteNaReceitaPK getInNaRecPK() {
        return inNaRecPK;
    }

    public void setInNaRecPK(IngredienteNaReceitaPK inNaRecPK) {
        this.inNaRecPK = inNaRecPK;
    }
    
    public void setInNaRecPK(Long recId, Long ingId) {
        inNaRecPK = new IngredienteNaReceitaPK(recId, ingId);
    }
    
}
