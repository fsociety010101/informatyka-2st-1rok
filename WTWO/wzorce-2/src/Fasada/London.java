package Fasada;

import java.util.HashMap;

public class London implements City {
    HashMap<String, Double> firmy = new HashMap<>();

    London() {
        firmy.put("ORLACL", 0.0);
        firmy.put("GOOGLE", 67.0);
    }

    double getRisk(String code, int days) {
        return firmy.getOrDefault(code, -1.0);
    }
}
