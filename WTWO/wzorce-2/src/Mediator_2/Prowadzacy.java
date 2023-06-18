package Mediator_2;

public class Prowadzacy {

    int id;
    Mediator mediator;

    public Prowadzacy(int id, Mediator mediator) {
        this.id = id;
        this.mediator = mediator;
    }

    public int getId() {
        return id;
    }


    public void wyslij_wiadomosc_student(String wiadomosc, int id) {
        this.mediator.wyslij_wiadomosc_prow_stud(wiadomosc, id);

    }

    public void zamiesc_ogloszenie(String wiadomosc) {
        this.mediator.zamiesc_ogloszenie_prow(wiadomosc);
    }
    public void update(String wiadomosc){
        System.out.println("Prowadzący o id = " + this.id + "otrzymał wiadomość " + wiadomosc);
    }
}
