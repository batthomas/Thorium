package ch.herzog.thorium.event.events;

import ch.herzog.thorium.event.CancellableEvent;
import ch.herzog.thorium.event.listeners.ChatOutputListener;

import java.util.List;

public class ChatOutputEvent extends CancellableEvent<ChatOutputListener> {

    private String message;

    public ChatOutputEvent(String message) {
        this.message = message;
    }

    @Override
    public void fire(List<ChatOutputListener> listeners) {
        for (ChatOutputListener listener : listeners) {
            if (isCancelled()) break;
            listener.onSendMessage(this);
        }
    }

    @Override
    public Class<ChatOutputListener> getListenerType() {
        return ChatOutputListener.class;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
