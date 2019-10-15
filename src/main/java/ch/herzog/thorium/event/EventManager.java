package ch.herzog.thorium.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {

    private Map<Class<? extends Listener>, List<Listener>> listeners;

    public EventManager() {
        listeners = new HashMap<>();
    }

    public void add(Listener listener) {
        Class<?>[] interfaces = listener.getClass().getInterfaces();
        for (Class<?> inter : interfaces) {
            if (Listener.class.isAssignableFrom(inter)) {
                @SuppressWarnings("unchecked")
                Class<Listener> listenerClass = (Class<Listener>) inter;
                List<Listener> list = listeners.computeIfAbsent(listenerClass, k -> new ArrayList<>());
                list.add(listener);
            }
        }
    }

    public void remove(Listener listener) {
        Class<?>[] interfaces = listener.getClass().getInterfaces();
        for (Class<?> inter : interfaces) {
            if (Listener.class.isAssignableFrom(inter)) {
                @SuppressWarnings("unchecked")
                Class<Listener> listenerClass = (Class<Listener>) inter;
                List<Listener> list = listeners.getOrDefault(listenerClass, null);
                if (list != null) {
                    list.remove(listener);
                }
            }
        }
    }

    public <L extends Listener, E extends Event<L>> void fire(E event) {
        Class<L> type = event.getListenerType();
        List<Listener> list = listeners.getOrDefault(type, null);
        if (list != null) {
            @SuppressWarnings("unchecked")
            List<L> temp = (List<L>) list;
            event.fire(temp);
        }
    }

}
