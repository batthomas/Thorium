package ch.herzog.thorium.gui;

public abstract class Component {

    private int x;
    private int y;
    private int width;
    private int height;

    public Component(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void render(int mouseX, int mouseY, float partialTicks);

    public abstract void onMouseClick(int mouseX, int mouseY, int mouseButton);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
