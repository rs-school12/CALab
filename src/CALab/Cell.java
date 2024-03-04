package CALab;

import mvc.Publisher;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Cell extends Publisher implements Serializable {
    private int row;
    private int col;

    private Grid myGrid;

    private List<Cell> neighbors = new ArrayList<>(8);

    private Cell partner = null;

    public abstract void observe();
    public abstract void interact();
    public abstract void update();

    public abstract void reset(boolean random);

    public Cell getPartner(){
        return partner;
    }

    public void setPartner(Cell partner){
        this.partner = partner;
    }
    public void choosePartner(){
        List<Cell> partnerless = new ArrayList<>();
        for (Cell c : neighbors){
            if (c.getPartner() == null){
                partnerless.add(c);
            }
        }
        if (!partnerless.isEmpty()) {
            Random r = new Random();
            int i = r.nextInt(partnerless.size());
            partnerless.get(i).setPartner(this);
            this.partner = partnerless.get(i);
        }
    }

    public void unpartner(){
        partner = null;
    }

    public Color getColor(){
        return null;
    }
}
