import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int gridWidth = 100;
        int gridHeight = 100;

        // zmiana regul
        int[] S, B;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zdefiniuj reguly w zboriach S i B: ");
        System.out.print("1 - Domyslne: S = {2, 3}; B = {3};\n2 - Wprowadz inne\n\nTwoj wybor: ");
        int option = scanner.nextInt();
        switch (option) {
            case 2:
                System.out.print("Ilosc regul w zbiorze S = ");
                int size = scanner.nextInt();
                S = new int[size];
                System.out.print("S = ");
                for (int i = 0; i < size; ++i)
                    S[i] = scanner.nextInt();
                System.out.print("Ilosc regul w zbiorze B = ");
                size = scanner.nextInt();
                B = new int[size];
                System.out.print("B = ");
                for (int i = 0; i < size; ++i)
                    B[i] = scanner.nextInt();
                break;
            default:
                S = new int[]{2, 3};
                B = new int[]{3};
                break;
        }

        System.out.print("\nZbior S = ");
        for (int i : S) System.out.print(i + "; ");
        System.out.print("\nZbior B = ");
        for (int i : B) System.out.print(i + "; ");

        /*
        ustawienie warunkow brzegowych w funkcji:
        przenikajace - przekraczają jedną krawędź siatki, pojawiają się ponownie na przeciwległej krawędzi
        pochlaniajace - komórki, które minęły jedną krawędź siatki, są pochłaniane i znikają, kończąc symulację
        odbijajace - komórki, które osiągają krawędź siatki, odbijają się oo siatki (jak 1 - zza krawedzia 0, jak 0 - zza krawedzia 1
        */
        System.out.println("\nWybierz typ brzegow: ");
        System.out.print("1 - Przenikajace\n2 - Pochlaniajace\n3 - Odbijajace\n\nTwoj wybor: ");
        String borderType = "";
        option = scanner.nextInt();
        switch (option) {
            case 2 -> borderType = "pochlaniajace";
            case 3 -> borderType = "odbijajace";
            default -> borderType = "przenikajace";
        }

        /*
        przyklady:
        "examples/n1.txt" - https://conwaylife.com/wiki/Blinker
        "examples/n2.txt" - https://conwaylife.com/wiki/Spaceship
        "examples/n3.txt" - https://conwaylife.com/wiki/Pulsar
        "examples/n4.txt" - https://conwaylife.com/wiki/Reflectorless_rotating_oscillator
        "examples/n5.txt" - https://conwaylife.com/wiki/David_Hilbert
        "examples/n6.txt" - https://conwaylife.com/wiki/P23_honey_farm_hassler
        */
        System.out.println("\nWybierz przyklad do wizualizacji: ");
        System.out.println("1 - Blinker\n2 - Spaceship\n3 - Pulsar\n4 - Reflectorless_rotating_oscillator");
        System.out.print("5 - David_Hilbert\n6 - P23_honey_farm_hassler\n7 - Losowa siatka\n8 - Wlasny przyklad wpisany w pliku\n\nTwoj wybor: ");
        option = scanner.nextInt();

        String fileName = "";
        boolean random = false;
        switch (option) {
            case 1 -> fileName = "examples/n1.txt";
            case 2 -> fileName = "examples/n2.txt";
            case 3 -> fileName = "examples/n3.txt";
            case 4 -> fileName = "examples/n4.txt";
            case 5 -> fileName = "examples/n5.txt";
            case 6 -> fileName = "examples/n6.txt";
            case 8 -> fileName = "examples/wlasny.txt";
            default -> random = true;
        }

        CellularAutomaton automaton = new CellularAutomaton(gridWidth, gridHeight, S, B, borderType);
        if (random) automaton.randomizeGrid();
        else automaton.readFromFile(fileName);

        // wizualizacja
        JFrame frame = new JFrame();
        frame.getContentPane().add(automaton);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
        // regulowanie szybkosci
        new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                automaton.evaluateGrid();
                automaton.repaint();
            }
        }).start();
    }
}