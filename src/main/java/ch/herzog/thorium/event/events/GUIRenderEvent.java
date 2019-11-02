package ch.herzog.thorium.event.events;

import ch.herzog.thorium.event.Event;
import ch.herzog.thorium.event.listeners.GUIRenderListener;

import java.util.List;

public class GUIRenderEvent extends Event<GUIRenderListener> {

    private float partialTicks;

    public GUIRenderEvent(float partialTicks) {
        this.partialTicks = partialTicks;
    }

    @Override
    public void fire(List<GUIRenderListener> listeners) {
        for (GUIRenderListener listener : listeners) {
            listener.onGUIRender(this);
        }
    }

    @Override
    public Class<GUIRenderListener> getListenerType() {
        return GUIRenderListener.class;
    }

    public float getPartialTicks() {
        return partialTicks;
    }
}
