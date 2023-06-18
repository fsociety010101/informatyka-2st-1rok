package EventBroker.Events;

public class EventChange {
    private final double data;
    private final EventType type;

    public EventChange(double data, EventType type) {
        this.data = data;
        this.type = type;
    }

    public double getData() {
        return this.data;
    }

    public EventType getType() {
        return this.type;
    }
}
