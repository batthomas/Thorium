package ch.herzog.thorium.event.events;

import ch.herzog.thorium.event.Event;
import ch.herzog.thorium.event.listeners.UpdateListener;

import java.util.List;

public class UpdateEvent extends Event<UpdateListener> {

    @Override
    public void fire(List<UpdateListener> listeners) {
        for (UpdateListener listener : listeners) {
            listener.onUpdate();
        }
    }

    @Override
    public Class<UpdateListener> getListenerType() {
        return UpdateListener.class;
    }

}
