package wyjatkitest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author luke
 */
public class KinoFrame {
    //Odkomentuj ponizej po stworzeniu klasy Film w projekcie:
    //static Film film;


    public static void main(String[] args) {
        //Odkomentuj ponizej po stworzeniu klasy Film w projekcie:
        //film = new Film(124,6);
        JFrame frame = new JFrame("Test");
        frame.setVisible(true);
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        JButton button = new JButton("Dodaj");
        panel.add(button);
        button.addActionListener(new DodajRezerwacje());
        JButton button2 = new JButton("Wyswietl");
        panel.add(button2);
        button2.addActionListener(new Wyswietl());

    }

    static class DodajRezerwacje implements ActionListener {
        public void actionPerformed(ActionEvent e) {

//pobierz od użytkownika za pomoca JoptionPane.showInputDialog
//imie i nazwisko odzielone przecinkiem. Utwórz nowy obkiet Osoba,
//oraz dodaj ja do rezerwacji za pomoca metody:
//film.addOsoba(o) ;
//	o- obiekt typu Osoba
//	addOsoba metoda która napisalismy w poprzednim podpunkcie.
//Film.addOsoba(o) wyrzuca wyj±tek BrakWolnychMiejsc w obsłudze tego wyjatku,
//wyswietl ten bład za pomoca JoptionPane.showMessageDialog

        }
    }


    static class Wyswietl implements ActionListener {
        public void actionPerformed(ActionEvent e) {
//      Wyswietl obiekt typu film, kod filmu, oraz zajete miejsca.
//      za pomoca znanej Ci metody z klasy JOptionPane.

        }
    }
}