package Decorator;

import Copmosite.FirmComponent;

public class GoldenFirm extends BaseDecorator {
    public GoldenFirm(FirmComponent firmComponentDecorator) {
        super(firmComponentDecorator);
    }

    @Override
    public double calculateBonificate(String NIP) {
        double res = 30;
        if (this.firmComponentDecorator != null)
            res += this.firmComponentDecorator.calculateBonificate(NIP);
        return res;
    }
}
