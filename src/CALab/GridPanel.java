package CALab;

import mvc.AppPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class GridPanel extends AppPanel {
    private JButton run1;
    private JButton run50;
    private JButton populate;
    private JButton clear;
    public GridPanel(GridFactory gridfactory) {
        super(gridfactory);
        controlPanel.setLayout(new GridLayout(2,2));

        run1 = new JButton("Run1");
        run1.addActionListener(this);
        controlPanel.add(createButtonPanel(run1));
        run50 = new JButton("Run50");
        run50.addActionListener(this);
        controlPanel.add(createButtonPanel(run50));
        populate = new JButton("Populate");
        populate.addActionListener(this);
        controlPanel.add(createButtonPanel(populate));
        clear = new JButton("Clear");
        clear.addActionListener(this);
        controlPanel.add(createButtonPanel(clear));
    }

    private JPanel createButtonPanel(JButton button) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0)); // Center-align buttons
        panel.add(button);
        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        try {
            switch (cmd){
            case "Run1":
            case "Run50":
            case "Populate":
            case "Clear":
                factory.makeEditCommand(model,cmd,this).execute();
                break;
        }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        super.actionPerformed(e);
    }

}
