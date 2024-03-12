package CALab;

import mvc.AppFactory;
import mvc.AppPanel;


public class GridPanel extends AppPanel {
    private JButton change;
    public GridPanel(GridFactory gridfactory) {
        super(gridfactory);
        change = new JButton("Change");
        change.addActionListener(this);
        controlPanel.add(change);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        try {
            switch (cmd){
                case "Change":
                    factory.makeEditCommand(model,"Change",this).execute();
                    break;
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) {
        AppFactory factory = new GridFactory();
        AppPanel panel = new GridPanel(factory);
        panel.display();
    }
}
