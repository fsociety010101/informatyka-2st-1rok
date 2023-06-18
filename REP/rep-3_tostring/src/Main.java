public class Main {
    public static void main(String[] args) {
        // Punkty
        Punkt test1 = new Punkt(-1, 0);
        Punkt test2 = new Punkt(1, -1);
        Punkt test3 = new Punkt(1, 2);

        String punkt_test = test1.toString();
        System.out.println(punkt_test);

        // Odcinki
        Odcinek odcinek1 = new Odcinek(test1, test2);
        Odcinek odcinek2 = new Odcinek(test1, test3);
        Odcinek odcinek3 = new Odcinek(test2, test3);

        String odcinek_test = odcinek1.toString();
        System.out.println(odcinek_test);

        // Trojkat
        Trojkat trojkat1 = new Trojkat(odcinek1, odcinek2, odcinek3);

        String trojkat_test = trojkat1.toString();
        System.out.println(trojkat_test);

        // StringBuilder
        long millisActualTime = System.currentTimeMillis();
        String s1 = "test";
        for (int i = 0; i < 50000; i++) {
            s1 = s1 + i;
        }
        long executionTime = System.currentTimeMillis() - millisActualTime;
        System.out.println("Czas dla +: " + executionTime);

        millisActualTime = System.currentTimeMillis();
        String s2 = "test";
        StringBuilder sb = new StringBuilder(s2);
        for (int i = 0; i < 50000; i++) {
            s2 = sb.append(i).toString();
        }
        executionTime = System.currentTimeMillis() - millisActualTime;
        System.out.println("Czas dla StringBuilder: " + executionTime);

        // Szyfr Cezara
        SzyfrCezara szyfr1 = new SzyfrCezara(20);
        // Szyfrowanie za pomoca klucza
        szyfr1.szyfruj("Hello World, it's me - Mario!");

        // Deszyfrowanie za pomoca klucza
        szyfr1.deszyfrujKlucz("BYFFI QILFX, CN'M GY - GULCI!");

        // Deszyfrowanie brute force
        szyfr1.deszyfrujBruteForce("BYFFI QILFX, CN'M GY - GULCI!");
    }
}