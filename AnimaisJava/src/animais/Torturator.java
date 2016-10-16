// exemplo para o fórum
package animais;

// utiliza as classes Pato e Galinha
// o Método grite será processado
// polimorficamente
public class Torturator {
    
    private Integer id;
    private String nome;
    
    public Torturator() {}
    
    public Torturator(Integer i, String n) {
        id = i;
        nome = n;
    }
    
    public String aperta(Bicho bicho) {
        return bicho.grite();
    }
    
    @Override
    public String toString() {
        return getId() +": "+getNome();
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
