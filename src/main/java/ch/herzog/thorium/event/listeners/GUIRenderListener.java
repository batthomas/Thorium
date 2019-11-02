package ch.herzog.thorium.event.listeners;

import ch.herzog.thorium.event.Listener;
import ch.herzog.thorium.event.events.GUIRenderEvent;

public interface GUIRenderListener extends Listener {

    void onGUIRender(GUIRenderEvent event);

}
