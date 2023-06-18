package Decorator;

import Copmosite.FirmComponent;

public class NIPDate extends BaseDecorator {
    public NIPDate(FirmComponent firmComponentDecorator) {
        super(firmComponentDecorator);
    }

    @Override
    public double calculateBonificate(String NIP) {
        double res = 15;
        if (this.firmComponentDecorator != null)
            res += this.firmComponentDecorator.calculateBonificate(NIP);
        return res;
    }
}
