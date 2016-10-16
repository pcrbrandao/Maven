package animais;

public enum Torturators {
    T1(1, "Torturator 1"),
    T2(2, "Torturator 2"),
    T3(3, "Torturator 3");
    
    private Integer id;
    private String nome;
    
    Torturators(Integer i, String n) {
        id = i;
        nome = n;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
