package Fasada;

import java.util.HashMap;

public class NewYork implements City {
    HashMap<String, Double> firmy = new HashMap<>();

    NewYork() {
        firmy.put("AMAZON", 25.0);
        firmy.put("GOOGLE", 78.0);
    }

    double companyTrustworthy(String code, int days) {
        return firmy.getOrDefault(code, -1.0);
    }
}
