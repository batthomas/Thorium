package ch.herzog.thorium.gui.hud;

import ch.herzog.thorium.event.events.GUIRenderEvent;
import ch.herzog.thorium.event.listeners.GUIRenderListener;
import ch.herzog.thorium.gui.Component;
import ch.herzog.thorium.gui.hud.components.LabelComponent;
import ch.herzog.thorium.gui.hud.components.ModuleListComponent;
import ch.herzog.thorium.module.Module;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

public class InGameHud extends Module implements GUIRenderListener {

    private List<Component> components;

    public InGameHud() {
        super("InGameHud", "Ingame Information");
        components = new ArrayList<>();
        initComponents();
    }

    private void initComponents() {
        components.add(new LabelComponent("§nThorium Client", 3, 3));
        components.add(new ModuleListComponent(3, 17));
    }

    @Override
    public void onGUIRender(GUIRenderEvent event) {
        for (Component component : components) {
            component.render(0, 0, event.getPartialTicks());
        }
        resetGL();
    }

    private void resetGL() {
        GL11.glColor4f(1, 1, 1, 1);
    }

}
