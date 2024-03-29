package mvc;

import javax.swing.*;
//import java.awt.*;

public class View extends JPanel implements Subscriber {

    public Model model;
    public View(Model m) {
        model = m;
        model.subscribe(this);
    }

    public void update() {
        repaint();
    }

    public void setModel(Model model) {
        this.model.unsubscribe(this);
        this.model = model;
        this.model.subscribe(this);
    }
}
