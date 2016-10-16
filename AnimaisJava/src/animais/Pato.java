// exemplo para o fórum
package animais;

// implementa Bicho
public class Pato extends Ave {
    
    public Pato(String v, String n, String g) {
        super(v, n, g);
    }
    
    @Override
    public String grite() {
        return getAtributos();
    }
}
