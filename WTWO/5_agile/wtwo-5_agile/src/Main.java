import Copmosite.FirmComponent;
import Copmosite.FirmLeaf;
import Decorator.AllOdd;
import Decorator.DivByThree;
import Visitor.JSON;
import Visitor.XML;

public class Main {
    public static void main(String[] args) {
        FirmLeaf firm1 = new FirmLeaf("Firma1", "Adres1", "NIP1", 10000.0, 15000.0, "");
        FirmLeaf firm2 = new FirmLeaf("Firma2", "Adres2", "NIP2", 15000.0, 3000.0, "");
        FirmLeaf firm3 = new FirmLeaf("Firma3", "Adres3", "NIP3", 9000.0, 109000.0, "");

        FirmComponent firmComponent = new AllOdd(new DivByThree(null));

        System.out.println("Suma: " + firmComponent.calculateBonificate(firm1.getNIP()));

        XML xmlVisitor = new XML();
        System.out.println(xmlVisitor.convertFirm(firm1));

        JSON jsonVisitor = new JSON();
        System.out.println(jsonVisitor.convertFirm(firm2));
    }
}