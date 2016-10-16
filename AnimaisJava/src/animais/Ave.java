package animais;

public abstract class Ave implements Bicho {
    
    private String voa, nada, 
            grito, atributos, nomeDaAve;
    
    public Ave() {};
    
    public Ave(String v, String n, String g) {
        voa = v;
        nada = n;
        grito = g;
        nomeDaAve = this.getClass().getName();
        atributos = String.format("%s: Eu vôo? %s, nado? %s, Grito? %s", 
                nomeDaAve, voa, nada, grito);
    }

    public String getVoa() {
        return voa;
    }

    public void setVoa(String voa) {
        this.voa = voa;
    }

    public String getNada() {
        return nada;
    }

    public void setNada(String nada) {
        this.nada = nada;
    }

    public String getGrito() {
        return grito;
    }

    public void setGrito(String grito) {
        this.grito = grito;
    }

    public String getAtributos() {
        return atributos;
    }

    public void setAtributos(String atributos) {
        this.atributos = atributos;
    }

    public String getNomeDaAve() {
        return nomeDaAve;
    }

    public void setNomeDaAve(String nomeDaAve) {
        this.nomeDaAve = nomeDaAve;
    }
}
