package Mediator;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.List;

public class Lodowka implements Compnent{
    Mediator mediator;
    List<String> lista_prod = new ArrayList<>();
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;

    }
    public boolean sprawdz(String produkt){
        System.out.println("Sprawdzam " + produkt);
        if(lista_prod.contains(produkt)){
            return true;
        }else{
            return false;
        }
    }
    public void wyjmij(String produkt){
        if(produkt.equals("imbir")){
            mediator.call_all("wyjęty imbir");

        }
        System.out.println("Został wyjęty " + produkt);

    }


}
