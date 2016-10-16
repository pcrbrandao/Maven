/**
 * Contem os arquivos do sistema
 */
package org.receitas.enums;

/**
 *
 * @author pcrbrandao
 */
public enum Arquivo {
    INDEX ("/Receitas", "index.jsp"),
    AUT_ERRO("jsp", "AutenticaErro.jsp"),
    RESULT("jsp", "Resultado.jsp" ),
    MENU("jsp", "Menu.jsp"),
    ENC_SESSAO("jsp", "EncerraSessao.jsp"),
    LISTA_ENTIDADE("jsp","ListaEntidade.jsp"),
    LISTA("jsp", "Lista"),
    EDITAR("jsp", "Editar");
    
    private final String arquivo;
    private final String path;
    
    private Arquivo(String p, String a) {
        arquivo = a;
        path = p;
    }
    
    public String getArquivoFull() {
        return String.format("%s/%s", path, arquivo);
    }
    
    public String getArquivo() {
        return arquivo;
    }
    
    public String getPath() {
        return path;
    }
}
