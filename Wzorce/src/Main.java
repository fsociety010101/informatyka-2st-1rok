import Stan_3.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Detektyw_Fix detektywFix = new Detektyw_Fix();
        Detektyw_Scotland detektywScotland = new Detektyw_Scotland();
        Broker broker = new Broker();
        FileasFogg fileasFogg = new FileasFogg(broker);
        broker.register(EventType.ZMIANA_KONTYNENTU, detektywScotland);
        broker.register(EventType.ZMIANA_MIASTA, detektywFix);
        Scanner sc =new Scanner(System.in);
        while (true){
            fileasFogg.goNext();
        }


    }
}