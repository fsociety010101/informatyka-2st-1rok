package Observers;

import Events.EventChange;

public interface Observer {
    void update(EventChange change);
}