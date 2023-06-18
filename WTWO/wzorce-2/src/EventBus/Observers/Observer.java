package EventBus.Observers;

import EventBus.Events.EventChange;

public interface Observer {
    void update(EventChange change);
}