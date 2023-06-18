public class Odcinek {

    public Odcinek(Punkt punkt1, Punkt punkt2) {
        this.punkt1 = punkt1;
        this.punkt2 = punkt2;
        setDlugosc();
    }

    public Odcinek(double x1, double y1, double x2, double y2) {
        punkt1 = new Punkt(x1, y1);
        punkt2 = new Punkt(x2, y2);
        setDlugosc();
    }

    private Punkt punkt1, punkt2;
    private double dlugosc;

    public Punkt getPunkt1() {
        return punkt1;
    }

    public void setPunkt1(Punkt punkt1) {
        this.punkt1 = punkt1;
        setDlugosc();
    }

    public Punkt getPunkt2() {
        return punkt2;
    }

    public void setPunkt2(Punkt punkt2) {
        this.punkt2 = punkt2;
        setDlugosc();
    }

    public double getDlugosc() {
        return dlugosc;
    }

    private void setDlugosc() {
        this.dlugosc = Math.sqrt(Math.pow(this.punkt2.getY() - this.punkt1.getY(), 2) + (Math.pow(this.punkt2.getX() - this.punkt1.getX(), 2)));
    }

    public void displayOdcinek() {
        System.out.println("------------------------------\n" + "Punkt 1:");
        punkt1.displayPunkt();

        System.out.println("\nPunkt 2:");
        punkt2.displayPunkt();

        System.out.println("\nDlugosc: " + getDlugosc());
    }

    @Override
    public String toString() {
        return "odcinek: [ p1 [" + this.punkt1.getX() + ", " + this.punkt1.getY() + " ], " +
                "p2 [ " + this.punkt2.getX() + ", " + this.punkt2.getY() + " ], dlugosc = " + this.dlugosc + " ]";
    }
}
