package life;

import CALab.Cell;
import CALab.Grid;

import java.awt.*;
import java.util.Random;

public class Agent extends Cell {

    private int status;

    private int ambience;

    public Agent(Society g) {
        super(g);
    }

    @Override
    public void observe() {
        ambience = 0;
        for (Cell c:neighbors){
            if (c.getStatus() == 0){
                ambience++;
            }
        }
    }

    @Override
    public void interact() {

    }

    @Override
    public void update() {
        if (Society.death.contains(ambience) && this.getStatus()==0){
            this.nextState();
        }else if (Society.rebirth.contains(ambience) && this.getStatus()==1){
            this.nextState();
        }
    }

    @Override
    public void reset(boolean random) {
        if (!random){
            status = 0;
        }else {
            Random r = new Random();
            status = r.nextInt(2);
        }
        myGrid.changed();
        notifySubscribers();
    }

    @Override
    public void nextState() {
        if (status == 0){
            status = 1;
        }else{
            status = 0;
        }
        myGrid.changed();
        notifySubscribers();
    }

    @Override
    public Color getColor() {
        return status==0?Color.green:Color.red;
    }

    @Override
    public int getStatus() {
        return status;
    }
}
