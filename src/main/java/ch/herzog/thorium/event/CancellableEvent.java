package ch.herzog.thorium.event;

public abstract class CancellableEvent<T extends Listener> extends Event<T> {

    private boolean cancelled = false;

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public boolean isCancelled() {
        return cancelled;
    }

}
