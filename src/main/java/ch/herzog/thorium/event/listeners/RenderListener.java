package ch.herzog.thorium.event.listeners;

import ch.herzog.thorium.event.Listener;
import ch.herzog.thorium.event.events.RenderEvent;

public interface RenderListener extends Listener {

    void onRender(RenderEvent event);

}
