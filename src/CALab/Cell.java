package CALab;

import mvc.Publisher;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Cell extends Publisher implements Serializable {

    protected int row;
    protected int col;

    protected transient Grid myGrid;

    public transient List<Cell> neighbors = new ArrayList<>();

    protected Cell partner = null;

    public Cell(Grid g){
        myGrid = g;
    }

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

    public void unpartner() {
        if (partner != null) {
            if (partner.partner != null) {
                partner.partner = null;
            }
        }
    }

    public abstract Color getColor();

    public abstract void nextState();
    public abstract int getStatus();

    public abstract int getLabel();

    public void setMyGrid(Grid g){
        this.myGrid = g;
    }

    public void setLocation(int row, int col){
        this.row = row;
        this.col = col;
    }

}