package animais;

public enum Galinhas {
    
    G1(1, "Galinha 1"),
    G2(2, "Galinha 2"),
    G3(3, "Galinha 3"),
    G4(4, "Galinha 4");
    
    private Integer id;
    private String nome;
    
    Galinhas( Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
