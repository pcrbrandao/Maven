/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animais;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 *
 * @author pcrbrandao
 */
public class AnimaisTeste {
    
    public static void ConstrutorAve() {
        
        Bicho umBichoQualquer;
        Torturator torturator = new Torturator();
        
        umBichoQualquer = new Galinha("não", "não","Có!");
        String som = torturator.aperta(umBichoQualquer);
        System.out.println(som);
        umBichoQualquer = new Pato("sim", "sim", "Qua!!!");
        som = torturator.aperta(umBichoQualquer);
        System.out.println(som);
    }
    
    public static void testeTorturatorPegaGalinha() {
        
        
        Galinha galinha;
        Torturator torturator;
        Date data;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        TorturatorPegaGalinha tortura; // aqui está a classe de associação
        List<TorturatorPegaGalinha> torturas = new ArrayList<>();
        
        // Adicionando os dados
        for(Torturators t : Torturators.values()) {
            torturator = new Torturator(t.getId(),t.getNome());
            for(Galinhas g : Galinhas.values()) {
                galinha = new Galinha(g.getId(), g.getNome());
                data = Calendar.getInstance().getTime();
                tortura = 
                    new TorturatorPegaGalinha(data, torturator, galinha);
                torturas.add(tortura);
            }
        }
        
        // lendo os dados
        System.out.printf("%s\t\t%s\t\t%s\n", "Data", "Torturator", "Galinha");
        for(TorturatorPegaGalinha t : torturas) {
            System.out.printf("%s\t%s\t\t%s\n", 
                    df.format(t.getData()), t.getTorturator(), t.getGalinha());
        }
    }
}
