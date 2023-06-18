package Decorator;

import Copmosite.FirmComponent;

public class DivByThree extends BaseDecorator {
    public DivByThree(FirmComponent firmComponentDecorator) {
        super(firmComponentDecorator);
    }

    @Override
    public double calculateBonificate(String NIP) {
        double res = 100;
        if (this.firmComponentDecorator != null)
            res += this.firmComponentDecorator.calculateBonificate(NIP);
        return res;
    }
}
