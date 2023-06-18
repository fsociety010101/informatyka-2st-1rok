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

    static Punkt punktPrzeciecia(Odcinek odcinek1, Odcinek odcinek2) {
        // (x1 - x2) * (y3 - y4)
        // (y1 - y2) * (x3 - x4)
        double d1 = (odcinek1.punkt1.getX() - odcinek1.punkt2.getX()) * (odcinek2.punkt1.getY() - odcinek2.punkt2.getY());
        double d2 = (odcinek1.punkt1.getY() - odcinek1.punkt2.getY()) * (odcinek2.punkt1.getX() - odcinek2.punkt2.getX());
        double d = (d1) - (d2);

        if (d == 0) {
            return new Punkt(0.0, 0.0);
        } else {
            // (x1 * y2 - y1 * x2)
            // (x3 * y4 - y3 * x4)
            double u1 = (odcinek1.punkt1.getX() * odcinek1.punkt2.getY() - odcinek1.punkt1.getY() * odcinek1.punkt2.getX());
            double u4 = (odcinek2.punkt1.getX() * odcinek2.punkt2.getY() - odcinek2.punkt1.getY() * odcinek2.punkt2.getX());

            // (x3 - x4)
            // (x1 - x2)
            // (y3 - y4)
            // (y1 - y2)
            double u2x = odcinek2.punkt1.getX() - odcinek2.punkt2.getX();
            double u3x = odcinek1.punkt1.getX() - odcinek1.punkt2.getX();
            double u2y = odcinek2.punkt1.getY() - odcinek2.punkt2.getY();
            double u3y = odcinek1.punkt1.getY() - odcinek1.punkt2.getY();

            // punkt przecięcia
            double px = (u1 * u2x - u3x * u4) / d;
            double py = (u1 * u2y - u3y * u4) / d;

            return new Punkt(px, py);
        }
    }
}
