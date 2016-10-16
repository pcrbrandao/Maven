package animais;

import java.util.Date;

public class TorturatorPegaGalinha {
    
    private Date data;
    private Torturator torturator;
    private Galinha galinha;
    
    public TorturatorPegaGalinha() {}
    
    public TorturatorPegaGalinha(Date d, Torturator t, Galinha g) {
        data = d;
        torturator = t;
        galinha = g;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Torturator getTorturator() {
        return torturator;
    }

    public void setTorturator(Torturator torturator) {
        this.torturator = torturator;
    }

    public Galinha getGalinha() {
        return galinha;
    }

    public void setGalinha(Galinha galinha) {
        this.galinha = galinha;
    }
    
}
