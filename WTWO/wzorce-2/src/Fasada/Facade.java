package Fasada;

public class Facade {
    private London london;
    private NewYork newYork;
    private Singapore singapore;


    Facade(London london, NewYork newYork, Singapore singapore) {
        this.london = london;
        this.newYork = newYork;
        this.singapore = singapore;
    }


    public static void main(String[] args) {
        London london1 = new London();
        NewYork newYork1 = new NewYork();
        Singapore singapore1 = new Singapore();

        Facade facade = new Facade(london1, newYork1, singapore1);

        System.out.println("Srednia pewnosci gieldy GOOGLE = " + facade.sredniaPewnosci("GOOGLE"));


    }

    double sredniaPewnosci(String code) {
//        double srednia = (london.getRisk(code, 10) + newYork.companyTrustworthy(code, 10) + singapore.getCompanyRisk(code, 10)) / 3;

        double srednia = 0.0;
        int count = 0;

        if (london.getRisk(code, 10) != -1.0) {
            count++;
            srednia += london.getRisk(code, 10);
        }

        if (newYork.companyTrustworthy(code, 10) != -1.0) {
            count++;
            srednia += newYork.companyTrustworthy(code, 10);
        }

        if (singapore.checkCompany(code)) {
            srednia += singapore.getCompanyRisk(code, 10);
            count++;
        }

        return srednia / count;
    }
}