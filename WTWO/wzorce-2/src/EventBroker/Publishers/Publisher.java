package EventBroker.Publishers;

import EventBroker.Bus;
import EventBroker.Events.EventChange;

public class Publisher {

    Bus bus;

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public void notify(EventChange change) {
        bus.fire(change);
    }
}

