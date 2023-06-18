package Visitor;

import Copmosite.FirmComponent;

public class XML implements Visitor {
    @Override
    public String convertFirm(FirmComponent firmComponent) {
        return "XML: " + firmComponent.getClass();
    }
}
