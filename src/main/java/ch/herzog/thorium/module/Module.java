package ch.herzog.thorium.module;

import ch.herzog.thorium.ThoriumClient;
import ch.herzog.thorium.event.Listener;

public abstract class Module {

    private String name;
    private String description;
    private boolean active;

    public Module(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        if (this.active != active) {
            this.active = active;
            if (active) {
                onEnable();
            } else {
                onDisable();
            }
        }
    }

    protected void onEnable() {
        if (Listener.class.isAssignableFrom(this.getClass())) {
            ThoriumClient.INSTANCE.getEventManager().add((Listener) this);
        }
    }

    protected void onDisable() {
        if (Listener.class.isAssignableFrom(this.getClass())) {
            ThoriumClient.INSTANCE.getEventManager().remove((Listener) this);
        }
    }

}
