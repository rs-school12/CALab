package CALab;

import mvc.Publisher;

import java.io.Serializable;

public abstract class Cell extends Publisher implements Serializable {
    private int row;
    private int col;

    public abstract void observe();
    public abstract void interact();
    public abstract void update();
}
