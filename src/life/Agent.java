package life;

import CALab.Cell;

import java.awt.*;

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
            if (c.getStatus() == 1){
                ambience++;
            }
        }
        notifySubscribers();
    }

    @Override
    public void interact() {

    }

    @Override
    public void update() {
        if (Society.death.contains(ambience) && status==1 || Society.rebirth.contains(ambience) && status==0){
            this.nextState();
        }
    }

    @Override
    public void reset(boolean random) {
        if (!random){
            status = 0;
        }else {
            status = 1;
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
        return status==0?Color.red:Color.green;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public int getLabel() {
        return ambience;
    }
}
