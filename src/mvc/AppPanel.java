package mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppPanel extends JPanel implements Subscriber, ActionListener {

    protected AppFactory factory;
    private JFrame frame;
    protected Model model;
    protected View view;
    protected JPanel controlPanel;

    // creates generic mvc app panel layout
    public AppPanel(AppFactory factory) {
        this.factory = factory;
        model = factory.makeModel();
        view = factory.makeView(model);
        controlPanel = new JPanel();
        controlPanel.setBackground(Color.pink);

        this.add(controlPanel);
        this.add(view);

        this.setLayout(new GridLayout(1,2));

        frame = new SafeFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setTitle(factory.getTitle());
        frame.setSize(500, 300);


        JMenuBar menuBar = new JMenuBar();
        menuBar.add(Utilities.makeMenu("File", new String[]{"New", "Save", "Open", "Quit"}, this));
        menuBar.add(Utilities.makeMenu("Edit", factory.getEditCommands(), this));
        menuBar.add(Utilities.makeMenu("Help", new String[]{"About", "Help"}, this));
        frame.setJMenuBar(menuBar);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) { 
        String cmd = e.getActionCommand();
        try {
            switch (cmd){
                case "New":
                    System.out.println("New");
                    Utilities.saveChanges(model);
                    setModel(factory.makeModel());
                    break;
                case "Save":
                    System.out.println("Save");
                    if (model.getFileName() == null) {
                        Utilities.save(model, true);
                    } else {
                        Utilities.save(model, false);
                    }
                    break;
                case "Open":
                    System.out.println("Open");
                    setModel(Utilities.open(model));
                    break;
                case "Quit":
                    System.out.println("Quit");
                    frame.dispose();
                    break;
                case "About":
                    System.out.println("About");
                    JOptionPane.showMessageDialog(null, factory.about(), "Help", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Help":
                    System.out.println("Help");
                    JOptionPane.showMessageDialog(null, factory.getHelp(), "Help", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    public void update() { //override in customization

    }

    public void display() { frame.setVisible(true);
    }

    public void setModel(Model newModel) {
        this.model.unsubscribe(this);
        this.model = newModel;
        this.model.subscribe(this);
        // view must also unsubscribe then resubscribe:
        view.setModel(this.model);
        model.changed();
    }

}
