package Mediator_2;

import java.util.ArrayList;
import java.util.List;

public class Mediator {
    List<Prowadzacy> lista_prow = new ArrayList<>();
    List<Student> lista_stud = new ArrayList<>();

    public void add_prow(Prowadzacy prowadzacy){
        this.lista_prow.add(prowadzacy);
    }
    public void add_stud(Student student){
        this.lista_stud.add(student);
    }

    public void zamiesc_ogloszenie_student(int id, String wiadomosoc){
        for(Student student: lista_stud){
            if (student.getId() != id) student.update(wiadomosoc);
        }

    }
    public void zamiesc_ogloszenie_prow( String wiadomosoc){
        for(Student student: lista_stud){
            student.update(wiadomosoc);
        }
    }
    public void wyslij_wiadomosc_stud_prow(String wiadomosc, int prowadzacy_id){
        lista_prow.get(prowadzacy_id).update(wiadomosc);

    }
    public void wyslij_wiadomosc_stud_stud(String wiadomosc, int student_id){
        lista_stud.get(student_id).update(wiadomosc);
    }
    public void wyslij_wiadomosc_prow_stud(String wiadomosc, int student_id){
        lista_stud.get(student_id).update(wiadomosc);
    }


}
