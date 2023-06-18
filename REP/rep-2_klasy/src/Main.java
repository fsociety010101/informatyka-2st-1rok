public class Main {
    public static void main(String[] args) {
        Punkt test1 = new Punkt(-1, 0);
        Punkt test2 = new Punkt(1, -1);
        Punkt test3 = new Punkt(1, 2);

        Odcinek odcinek1 = new Odcinek(test1, test2);
        Odcinek odcinek2 = new Odcinek(test1, test3);
        Odcinek odcinek3 = new Odcinek(test2, test3);

        Trojkat trojkat1 = new Trojkat(odcinek1, odcinek2, odcinek3);
        trojkat1.displayTrojkat();

        Punkt p = Odcinek.punktPrzeciecia(odcinek1, odcinek2);
        System.out.println("\nPunkt przeciecia: ");
        p.displayPunkt();
    }
}