package ch.herzog.thorium.event.listeners;

import ch.herzog.thorium.event.Listener;
import ch.herzog.thorium.event.events.ChatOutputEvent;

public interface ChatOutputListener extends Listener {

    void onSendMessage(ChatOutputEvent event);

}
