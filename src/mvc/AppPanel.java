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

    public AppPanel(AppFactory factory) {      // creates generic mvc app panel layout
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
                    factory.makeEditCommand(model,"Change",this).execute();
                    break;
                case "Save":
                    break;
                case "Open":
                    break;
                case "Quit":
                    break;
                case "About":
                    factory.about();
                    break;
                case "Help":
                    factory.getHelp();
                    break;
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    public void update() {

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

    public class FilePopup {
        static public String popup() {
            JTextField fileNameField = new JTextField();
            Object[] message = {
                    "Enter program file name (ex. tri):", fileNameField};
            int option = JOptionPane.showConfirmDialog(null, message, "File Name Input", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {

                return fileNameField.getText();
            }
            return "";
        }
    }
}
