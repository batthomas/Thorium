package ch.herzog.thorium.event;

import java.util.List;

public abstract class Event<T extends Listener> {

    public abstract void fire(List<T> listeners);

    public abstract Class<T> getListenerType();

}
