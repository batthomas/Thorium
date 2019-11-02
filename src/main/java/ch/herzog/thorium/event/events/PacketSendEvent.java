package ch.herzog.thorium.event.events;

import ch.herzog.thorium.event.CancellableEvent;
import ch.herzog.thorium.event.listeners.PacketSendListener;
import net.minecraft.network.Packet;

import java.util.List;

public class PacketSendEvent extends CancellableEvent<PacketSendListener> {

    private Packet packet;

    public PacketSendEvent(Packet packet) {
        this.packet = packet;
    }

    @Override
    public void fire(List<PacketSendListener> listeners) {
        for (PacketSendListener listener : listeners) {
            if (isCancelled()) break;
            listener.onPacketSend(this);
        }
    }

    @Override
    public Class<PacketSendListener> getListenerType() {
        return PacketSendListener.class;
    }

    public Packet getPacket() {
        return packet;
    }

}
