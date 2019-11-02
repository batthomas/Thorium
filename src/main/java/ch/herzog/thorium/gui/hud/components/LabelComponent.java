package ch.herzog.thorium.gui.hud.components;

import ch.herzog.thorium.ThoriumClient;
import ch.herzog.thorium.gui.Component;
import net.minecraft.client.font.TextRenderer;

public class LabelComponent extends Component {

    private String name;
    private int color;

    public LabelComponent(String name, int x, int y) {
        this(name, 0xffffffff, x, y);
    }

    public LabelComponent(String name, int color, int x, int y) {
        super(x, y);
        this.name = name;
        this.color = color;
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        TextRenderer textRenderer = ThoriumClient.INSTANCE.getMinecraft().textRenderer;
        textRenderer.drawWithShadow(name, getX(), getY(), color);
    }

    @Override
    public void onMouseClick(int mouseX, int mouseY, int mouseButton) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
