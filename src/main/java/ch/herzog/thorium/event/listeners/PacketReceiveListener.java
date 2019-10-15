package ch.herzog.thorium.event.listeners;

import ch.herzog.thorium.event.Listener;
import ch.herzog.thorium.event.events.PacketReceiveEvent;

public interface PacketReceiveListener extends Listener {

    void onPacketReceive(PacketReceiveEvent event);

}
