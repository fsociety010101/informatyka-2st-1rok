import java.util.Scanner;

public class PlanarSlope {
    private Double[][] surfaceScanningWindow = new Double[3][3];

    PlanarSlope() {
        inputSurfaceData();
        calculateSlopeDegree();
    }

    public static void main(String[] args) {
        PlanarSlope ps = new PlanarSlope();
    }

    private void inputSurfaceData() {
        System.out.println("Please type in surface data to calculate slope degree: ");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < surfaceScanningWindow.length; ++i)
            for (int j = 0; j < surfaceScanningWindow[i].length; ++j)
                this.surfaceScanningWindow[i][j] = sc.nextDouble();
        sc.close();
    }

    private void displaySurfaceData() {
        for (int i = 0; i < surfaceScanningWindow.length; ++i) {
            for (int j = 0; j < surfaceScanningWindow[i].length; ++j)
                System.out.print(" [" + this.surfaceScanningWindow[i][j] + "] ");
            System.out.print("\n");
        }
    }


    private void calculateSlopeDegree() {
        System.out.println("Calculating slope degree for this surface data: ");
        displaySurfaceData();

        double slopeDegree = 0.0;

        /*

        [a] [b] [c]
        [d] [e] [f]
        [g] [h] [i]

        we are calculating for e cell

        */

        Double a = this.surfaceScanningWindow[0][0];
        Double b = this.surfaceScanningWindow[0][1];
        Double c = this.surfaceScanningWindow[0][2];
        Double d = this.surfaceScanningWindow[1][0];
        Double f = this.surfaceScanningWindow[1][2];
        Double g = this.surfaceScanningWindow[2][0];
        Double h = this.surfaceScanningWindow[2][1];
        Double i = this.surfaceScanningWindow[2][2];


        // [dz/dx]
        int wght1 = 0;
        if (c != null) // c
            wght1 += 1;
        if (f != null) // f
            wght1 += 2;
        if (i != null) // i
            wght1 += 1;

        int wght2 = 0;
        if (a != null) // a
            wght2 += 1;
        if (d != null) // d
            wght2 += 2;
        if (g != null) // g
            wght2 += 1;

        Double dZdX = ((c + (2 * f) + i) * 4 / wght1 - (a + (2 * d) + g) * 4 / wght2) / (8 * 5);

        // [dz/dy]
        int wght3 = 0;
        if (g != null) // g
            wght3 += 1;
        if (h != null) // h
            wght3 += 2;
        if (i != null) // i
            wght3 += 1;

        int wght4 = 0;
        if (a != null) // a
            wght4 += 1;
        if (b != null) // b
            wght4 += 2;
        if (c != null) // c
            wght4 += 1;

        Double dZdY = ((g + (2 * h) + i) * 4 / wght3 - (a + (2 * b) + c) * 4 / wght4) / (8 * 5);


        // calculate rise_run = √ ([dz/dx]^2 + [dz/dy]^2)
        Double riseRun = Math.sqrt(Math.pow(dZdX, 2) + Math.pow(dZdY, 2));

        // calculate slope_degrees = ATAN (rise_run) * 57.29578
        Double slopeDegrees = Math.atan(riseRun) * 57.29578;

        System.out.println("Calculated slope deegre for this scanned surface window = " + slopeDegrees);
    }
}
