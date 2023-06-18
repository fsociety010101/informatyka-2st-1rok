package Fasada;

import java.util.HashMap;

public class Singapore implements City {
    HashMap<String, Double> firmy = new HashMap<>();

    Singapore(){
        firmy.put("AMAZON", 25.0);
        firmy.put("GOOGLE", 17.0);
    }

    boolean checkCompany(String code) {
        return firmy.containsKey(code);
    }

    double getCompanyRisk(String code, int months) {
        return firmy.get(code);
    }
}
