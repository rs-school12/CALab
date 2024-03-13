package life;

import CALab.GridFactory;
import CALab.GridPanel;
import mvc.AppFactory;
import mvc.AppPanel;

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
