package mvc;

import javax.swing.*;

public class View extends JPanel implements Subscriber {

    Model model;
    public View(Model m) {
        model = m;
        model.subscribe(this);
    }

    public void update() {

    }
}
