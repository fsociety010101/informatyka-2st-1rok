package Decorator;

import Copmosite.FirmComponent;

import java.util.Optional;

public abstract class BaseDecorator implements FirmComponent {
    protected FirmComponent firmComponentDecorator;

    public BaseDecorator(FirmComponent firmComponentDecorator) {
        this.firmComponentDecorator = firmComponentDecorator;
    }

    @Override
    public double calculateBonificate(String NIP) {
        if (this.firmComponentDecorator != null) {
            return this.firmComponentDecorator.calculateBonificate(NIP);
        }
        return 0;
    }
}
