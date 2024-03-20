package life;

import CALab.GridPanel;

public class LifePanel extends GridPanel {
    public LifePanel(LifeFactory lifeFactory) {
        super(lifeFactory);
    }
    public static void main(String[] args) {
        LifeFactory factory = new LifeFactory();
        LifePanel panel = new LifePanel(factory);
        panel.display();
    }
}
