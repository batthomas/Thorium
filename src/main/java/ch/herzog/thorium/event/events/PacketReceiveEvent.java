package ch.herzog.thorium.event.events;

import ch.herzog.thorium.event.CancellableEvent;
import ch.herzog.thorium.event.listeners.PacketReceiveListener;
import net.minecraft.network.Packet;

import java.util.List;

public class PacketReceiveEvent extends CancellableEvent<PacketReceiveListener> {

    private Packet packet;

    public PacketReceiveEvent(Packet packet) {
        this.packet = packet;
    }

    @Override
    public void fire(List<PacketReceiveListener> listeners) {
        for (PacketReceiveListener listener : listeners) {
            if (isCancelled()) break;
            listener.onPacketReceive(this);
        }
    }

    @Override
    public Class<PacketReceiveListener> getListenerType() {
        return PacketReceiveListener.class;
    }

    public Packet getPacket() {
        return packet;
    }

}
