package Copmosite;

import java.util.ArrayList;

public abstract class FirmHoldingComposite implements FirmComponent {

    protected double bonificate;

    protected String name;
    protected String address;
    protected String NIP;

    protected double annualIncome;
    protected double ordinaryIncome;
    protected String rivals;

    public FirmHoldingComposite(String name, String address, String NIP, double annualIncome, double ordinaryIncome, String rivals) {
        this.bonificate = 0;
        this.name = name;
        this.address = address;
        this.NIP = NIP;
        this.annualIncome = annualIncome;
        this.ordinaryIncome = ordinaryIncome;
        this.rivals = rivals;
    }
}
