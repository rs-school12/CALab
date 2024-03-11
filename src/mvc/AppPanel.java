package mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static mvc.Utilities.makeMenu;

public class AppPanel extends JPanel implements Subscriber, ActionListener {

    protected AppFactory factory;
    public JFrame frame;
    public Model model;
    public View view;
    public mvc.ControlPanel controlPanel;

    public AppPanel(AppFactory factory) {      // creates generic mvc app panel layout
        this.factory = factory;
        model = factory.makeModel();
        view = factory.makeView(model);
        controlPanel = factory.makeControlPanel(model);

        this.add(controlPanel);
        this.add(view);

        this.setLayout(new GridLayout(1,2));

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setTitle("App Panel");
        frame.setSize(500, 300);


        JMenuBar menuBar = new JMenuBar();
        menuBar.add(Utilities.makeMenu("File", new String[]{"New", "Save", "Open", "Quit"}, this));
        menuBar.add(Utilities.makeMenu("Edit", factory.getEditCommands(), this));
        menuBar.add(Utilities.makeMenu("Help", new String[]{"About", "Help"}, this));
        frame.setJMenuBar(menuBar);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }


    public void update() {

    }

    public void display() {
    }

    public class ControlPanel extends JPanel implements ActionListener {
        JFrame frame;
        Model model;
        public ControlPanel(Model model, JFrame frame) {
            this.frame = frame;
            this.model = model;
            JPanel p = new JPanel();
            add(p);
        }


        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }



}
