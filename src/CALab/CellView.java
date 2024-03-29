package CALab;

import mvc.Subscriber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CellView extends JButton implements ActionListener, Subscriber {
    private Cell myCell;

    public CellView(Cell c) {
        myCell = c;
        if (c != null) { c.subscribe(this); }
        this.addActionListener(this);
        update();
        setOpaque(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        myCell.nextState();
    }

    @Override
    public void update() {
        setBackground(myCell.getColor());
        setBorder(BorderFactory.createLineBorder(Color.black));
        setText("" + myCell.getLabel());
    }

    public void SetCell(Cell cell){
        this.myCell.unsubscribe(this);
        myCell = cell;
        this.myCell.subscribe(this);
    }
}