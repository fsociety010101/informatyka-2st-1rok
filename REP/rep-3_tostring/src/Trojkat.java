public class Trojkat {
    public Trojkat(Odcinek odcinek1, Odcinek odcinek2, Odcinek odcinek3) {
        this.odcinek1 = odcinek1;
        this.odcinek2 = odcinek2;
        this.odcinek3 = odcinek3;
        setObwod();
        setPole();
    }

    Odcinek odcinek1, odcinek2, odcinek3;
    private double pole, obwod;

    public Odcinek getOdcinek1() {
        return odcinek1;
    }

    public void setOdcinek1(Odcinek odcinek1) {
        this.odcinek1 = odcinek1;
        setObwod();
        setPole();
    }

    public Odcinek getOdcinek2() {
        return odcinek2;
    }

    public void setOdcinek2(Odcinek odcinek2) {
        this.odcinek2 = odcinek2;
        setObwod();
        setPole();
    }

    public Odcinek getOdcinek3() {
        return odcinek3;
    }

    public void setOdcinek3(Odcinek odcinek3) {
        this.odcinek3 = odcinek3;
        setObwod();
        setPole();
    }

    public double getPole() {
        return pole;
    }

    public void setPole() {
        // wzór Herona
        double p = (odcinek1.getDlugosc() + odcinek2.getDlugosc() + odcinek3.getDlugosc()) / 2;
        this.pole = Math.sqrt(p * (p - odcinek1.getDlugosc()) * (p - odcinek2.getDlugosc()) * (p - odcinek3.getDlugosc()));
    }

    public double getObwod() {
        return obwod;
    }

    public void setObwod() {
        this.obwod = odcinek1.getDlugosc() + odcinek2.getDlugosc() + odcinek3.getDlugosc();
    }

    public void displayTrojkat() {
        System.out.println("Obwod: " + getObwod());
        System.out.println("Pole: " + getPole() + "\n");
        odcinek1.displayOdcinek();
        odcinek2.displayOdcinek();
        odcinek3.displayOdcinek();
    }

    static Odcinek punktPrzeciecia(Odcinek odcinek1, Odcinek odcinek2) {
//        double x = ();
        return null;
    }

    @Override
    public String toString() {
        return "trojkat: [ p1 [" + this.odcinek1.getPunkt1().getX() + ", " + this.odcinek1.getPunkt1().getY() + " ], " +
                "p2 [ " + this.odcinek1.getPunkt2().getX() + ", " + this.odcinek1.getPunkt2().getY() + " ], " +
                "p3 [ " + this.odcinek2.getPunkt2().getX() + ", " + this.odcinek2.getPunkt2().getY() + " ], " +
                "obwod = " + this.obwod + ", pole = " + this.pole + " ]";
    }
}
