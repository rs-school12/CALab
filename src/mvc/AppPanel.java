package mvc;

import stoplight.StoplightFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppPanel implements Subscriber, ActionListener {

    JFrame frame;
    ControlPanel controlPanel;
    public AppPanel(AppFactory factory) {      // creates generic mvc app panel layout
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Blank App");
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

    public class ControlPanel {
        public ControlPanel() {

        }
    }

    public static void main(String[] args) {
        AppFactory factory = new StoplightFactory();
        AppPanel app = new AppPanel(factory);

    }

}
