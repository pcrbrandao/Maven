// exemplo para o fórum
package animais;

// galinha implementa Bicho
public class Galinha extends Ave {
    
    private Integer id;
    private String nome;
    
    public Galinha() {};
    
    public Galinha(Integer i, String n) {
        id = i;
        nome = n;
    }
    
    public Galinha(String v, String n, String g) {
        super(v, n, g);
    }
    
    @Override
    public String grite() {
        return getAtributos();
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
