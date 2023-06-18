package Mediator;

import java.util.ArrayList;
import java.util.List;

public class Lista implements Compnent {
    Mediator mediator;
    List<String> lista_zak = new ArrayList<>();

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void dodaj(String produkt) {
        lista_zak.add(produkt);
        System.out.println("Dodano do listy zakupów");
        if (produkt.equals("orzeszki")) {
            mediator.call_all("dodane orzeszki");
        }
    }
}
