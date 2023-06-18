package Mediator;

public class Komunikator implements Mediator {
    private Lodowka lodowka;
    private Muzyka muzyka;
    private Lista lista;

    public static void main(String[] args){
        Komunikator komunikator = new Komunikator();


        Muzyka muzyka1 = new Muzyka();
        muzyka1.setMediator(komunikator);
        Lista lista1 = new Lista();
        lista1.setMediator(komunikator);
        Lodowka lodowka1 = new Lodowka();
        lodowka1.setMediator(komunikator);
        komunikator.setLista(lista1);
        komunikator.setLodowka(lodowka1);
        komunikator.setMuzyka(muzyka1);
        lodowka1.wyjmij("imbir");
        muzyka1.odtworz("wesoła");
        lista1.dodaj("orzeszki");




    }
    @Override
    public void call_all(String event) {
        if (event.equals("wyjęty imbir")) {
            muzyka.odtworz("relaks");
        } else if (event.equals("wesoła muzyka")) {
            if (lodowka.sprawdz("drożdże")) {
                System.out.println("W lodówce są drożdże");
            } else {
                lista.dodaj("drożdże");
            }


        } else if (event.equals("dodane orzeszki")) {
            muzyka.utworz_playliste("Impreza");
        }
    }

    public void setLodowka(Lodowka lodowka) {
        this.lodowka = lodowka;
    }

    public void setMuzyka(Muzyka muzyka) {
        this.muzyka = muzyka;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }
}
