package ch.herzog.thorium.event.listeners;

import ch.herzog.thorium.event.Listener;
import ch.herzog.thorium.event.events.PacketSendEvent;

public interface PacketSendListener extends Listener {

    void onPacketSend(PacketSendEvent event);

}
