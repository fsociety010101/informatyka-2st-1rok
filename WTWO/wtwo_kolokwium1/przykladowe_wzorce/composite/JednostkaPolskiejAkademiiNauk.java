package composite;

import java.util.ArrayList;
import java.util.List;

public abstract  class JednostkaPolskiejAkademiiNauk implements Component {

    List<Component> elements;
    String address;

    JednostkaPolskiejAkademiiNauk(){
        elements = new ArrayList<Component>();
    }

    public  void  addElement(Component component){
        elements.add(component);
    }

    public String getAddress() {
        StringBuilder builder = new StringBuilder();
        builder.append(address);
        builder.append("\n");
        for (Component element: elements){
            builder.append(element.getAddress());
        }
        return builder.toString();
    }

}
