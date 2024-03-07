package mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        menuBar.add(makeFileMenu());
        menuBar.add(makeHelpMenu());
        menuBar.add(makeEditMenu());
        frame.setJMenuBar(menuBar);

        frame.setVisible(true);
    }

    private JMenu makeFileMenu() {
        JMenu result = new JMenu("File");
        result.setMnemonic('f');

        JMenuItem item = new JMenuItem("New", 'n');
        item.addActionListener(this);
        result.add(item);

        item = new JMenuItem("Open", 'o');
        item.addActionListener(this);
        result.add(item);

        item = new JMenuItem("Save", 's');
        item.addActionListener(this);
        result.add(item);

        item = new JMenuItem("Save As", 'a');
        item.addActionListener(this);
        result.add(item);

        item = new JMenuItem("Quit", 'q');
        item.addActionListener(this);
        result.add(item);

        return result;
    }

    private JMenu makeHelpMenu() {
        JMenu result = new JMenu("Help");
        result.setMnemonic('h');

        JMenuItem item = new JMenuItem("About", 'b');
        item.addActionListener(this);
        result.add(item);

        item = new JMenuItem("Help", 'b');
        item.addActionListener(this);
        result.add(item);

        return result;
    }

    private JMenu makeEditMenu() {
        JMenu result = new JMenu("Edit");
        result.setMnemonic('e');

        // edit menu should be abstract and pull from AppFactory for a list of EditCommands

        return result;
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
