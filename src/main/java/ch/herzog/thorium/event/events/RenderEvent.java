package ch.herzog.thorium.event.events;

import ch.herzog.thorium.event.Event;
import ch.herzog.thorium.event.listeners.RenderListener;

import java.util.List;

public class RenderEvent extends Event<RenderListener> {

    private float partialTicks;

    public RenderEvent(float partialTicks) {
        this.partialTicks = partialTicks;
    }

    @Override
    public void fire(List<RenderListener> listeners) {
        for (RenderListener listener : listeners) {
            listener.onRender(this);
        }
    }

    @Override
    public Class<RenderListener> getListenerType() {
        return RenderListener.class;
    }

    public float getPartialTicks() {
        return partialTicks;
    }
}
