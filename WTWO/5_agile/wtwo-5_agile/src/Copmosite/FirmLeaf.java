package Copmosite;

import java.util.ArrayList;

public class FirmLeaf extends FirmHoldingComposite {
    private double bonificate;

    private String name;
    private String address;
    private String NIP;

    private double annualIncome;
    private double ordinaryIncome;
    private String rivals;

    private boolean isGoldenFirm;

    public FirmLeaf(String name, String address, String NIP, double annualIncome, double ordinaryIncome, String rivals) {
        super(name, address, NIP, annualIncome, ordinaryIncome, rivals);
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getNIP() {
        return this.NIP;
    }

    @Override
    public double calculateBonificate(String NIP) {
        return 0;
    }
}
