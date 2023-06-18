public class SzyfrCezara {
    private String alfabet;
    private String zmienionyAlfabet;
    private final int offset;

    public SzyfrCezara(int klucz) {
        this.offset = klucz % 26;

        this.alfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        this.zmienionyAlfabet = this.alfabet.substring(offset);
        this.zmienionyAlfabet += this.alfabet.substring(0, offset);
    }

    public void szyfruj(String wiadomosc) {
        System.out.println("\n\nSzyfrowanie za pomoca klucza: ");
        wiadomosc = wiadomosc.toUpperCase();
        String wiadomoscSzyfr = "";
        StringBuilder sbWiadomoscSzyfr = new StringBuilder(wiadomoscSzyfr);

        int it;
        for (int i = 0; i < wiadomosc.length(); ++i) {
            if (!Character.isLetter(wiadomosc.charAt(i))) {
                wiadomoscSzyfr = sbWiadomoscSzyfr.append(wiadomosc.charAt(i)).toString();
            } else {
                it = alfabet.indexOf(wiadomosc.charAt(i));
                wiadomoscSzyfr = sbWiadomoscSzyfr.append(zmienionyAlfabet.charAt(it)).toString();
            }
        }
        System.out.println(wiadomoscSzyfr);
    }

    public void deszyfrujKlucz(String wiadomosc) {
        System.out.println("\n\nDeszyfrowanie za pomoca klucza: ");
        wiadomosc = wiadomosc.toUpperCase();
        String wiadomoscDeszyfr = "";
        StringBuilder sbWiadomoscDeszyfr = new StringBuilder(wiadomoscDeszyfr);

        int it;
        for (int i = 0; i < wiadomosc.length(); ++i) {
            if (!Character.isLetter(wiadomosc.charAt(i))) {
                wiadomoscDeszyfr = sbWiadomoscDeszyfr.append(wiadomosc.charAt(i)).toString();
            } else {
                it = zmienionyAlfabet.indexOf(wiadomosc.charAt(i));
                wiadomoscDeszyfr = sbWiadomoscDeszyfr.append(alfabet.charAt(it)).toString();
            }
        }
        System.out.println(wiadomoscDeszyfr);
    }

    public void deszyfrujBruteForce(String wiadomosc) {
        System.out.println("\n\nDeszyfrowanie brute force: ");

        wiadomosc = wiadomosc.toUpperCase();
        String wiadomoscDeszyfr = "";
        StringBuilder sbWiadomoscDeszyfr = new StringBuilder(wiadomoscDeszyfr);
        String tempAlfabet;
        int it;

        for (int i = 0; i < 26; ++i) {
            wiadomoscDeszyfr = "";
            sbWiadomoscDeszyfr = new StringBuilder(wiadomoscDeszyfr);

            tempAlfabet = this.alfabet.substring(i);
            tempAlfabet += this.alfabet.substring(0, i);

            for (int j = 0; j < wiadomosc.length(); ++j) {
                if (!Character.isLetter(wiadomosc.charAt(j))) {
                    wiadomoscDeszyfr = sbWiadomoscDeszyfr.append(wiadomosc.charAt(j)).toString();
                } else {
                    it = tempAlfabet.indexOf(wiadomosc.charAt(j));
                    wiadomoscDeszyfr = sbWiadomoscDeszyfr.append(alfabet.charAt(it)).toString();
                }
            }
            System.out.println(wiadomoscDeszyfr);
        }
    }
}
