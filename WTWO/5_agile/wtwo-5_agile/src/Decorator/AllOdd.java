package Decorator;

import Copmosite.FirmComponent;

public class AllOdd extends BaseDecorator {

    public AllOdd(FirmComponent firmComponentDecorator) {
        super(firmComponentDecorator);
    }

    @Override
    public double calculateBonificate(String NIP) {
        double res = 50;
        if (this.firmComponentDecorator != null)
            res += this.firmComponentDecorator.calculateBonificate(NIP);
        return res;
    }
}
