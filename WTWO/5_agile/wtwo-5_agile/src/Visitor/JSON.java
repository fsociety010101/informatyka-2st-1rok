package Visitor;

import Copmosite.FirmComponent;

public class JSON implements Visitor {
    @Override
    public String convertFirm(FirmComponent firmComponent) {
        return "JSON: " + firmComponent.getClass();
    }
}
