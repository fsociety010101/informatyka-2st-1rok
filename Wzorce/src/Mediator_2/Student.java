package Mediator_2;

public class Student {
    Mediator mediator;
    int id;

    public Student(Mediator mediator, int id) {
        this.mediator = mediator;
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void wyslij_wiadomosc_student(String wiadomosc, int id){
        this.mediator.wyslij_wiadomosc_stud_stud(wiadomosc, id);
    }
    public void wyslij_wiadomosc_prow(String wiadomosc, int id){
        this.mediator.wyslij_wiadomosc_stud_prow(wiadomosc, id);
    }
    public void stworz_ogloszenie(String wiadomosc){
        mediator.zamiesc_ogloszenie_student(this.id, wiadomosc);
    }
    public void update(String wiadomosc){
        System.out.println("Studeny o id = " + this.id + "otrzymał wiadomość " + wiadomosc);
    }

}
