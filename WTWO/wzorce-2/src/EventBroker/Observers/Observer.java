package EventBroker.Observers;

import EventBroker.Events.EventChange;

public interface Observer {
    void update(EventChange change);
}