package ch.herzog.thorium.gui.hud.components;

import ch.herzog.thorium.ThoriumClient;
import ch.herzog.thorium.gui.Component;
import ch.herzog.thorium.module.Module;
import net.minecraft.client.font.TextRenderer;

import java.util.Map;

public class ModuleListComponent extends Component {

    public ModuleListComponent(int x, int y) {
        super(x, y);
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {

        TextRenderer textRenderer = ThoriumClient.INSTANCE.getMinecraft().textRenderer;
        Map<String, Module> modules = ThoriumClient.INSTANCE.getModuleManager().getModules();
        int indexY = getY();

        for (Module module : modules.values()) {
            if (module.isActive()) {
                textRenderer.drawWithShadow(module.getName(), getX(), indexY, 0xffffffff);
                indexY += 9;
            }
        }
    }

    @Override
    public void onMouseClick(int mouseX, int mouseY, int mouseButton) {

    }

}
