package EventBus.Publishers;

import EventBus.Bus;
import EventBus.Events.EventChange;

public class Publisher {

    Bus bus;

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public void notify(EventChange change) {
        bus.fire(change);
    }
}

