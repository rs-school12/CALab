package CALab;

import mvc.Model;

import java.util.ArrayList;
import java.util.List;

public abstract class Grid extends Model {
    private static int time = 0;
    private int dim = 20;

    protected Cell[][] cells;

    public abstract Cell makeCell();

    public Grid(int dim){
        this.dim = dim;
        cells = new Cell[dim][dim];
        populate();
        repopulate(true);
    }

    public Grid(){
        this(20);
    }

    protected void populate(){
        for (int i = 0; i < dim; i++){
            for (int j = 0; j < dim; j++){
                cells[i][j] = makeCell();
            }
        }

        for (int i = 0; i < dim; i++){
            for (int j = 0; j < dim; j++){
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        if (i == x && j == y)
                            continue;

                        int X = x;
                        int Y = y;
                        if (x < 0){
                            X = dim - 1;
                        }else if (x >= dim){
                            X = 0;
                        }
                        if (y < 0){
                            Y = dim - 1;
                        }else if (y >= dim){
                            Y = 0;
                        }
                        cells[i][j].neighbors.add(cells[X][Y]);
                    }
                }
            }
        }
    }

    public void observe(){
        for (Cell[] list :cells){
            for (Cell c :list){
                c.observe();
            }
        }
    }

    public void interact(){
        for (Cell[] list :cells){
            for (Cell c :list){
                c.interact();
            }
        }
    }

    public void update(){
        for (Cell[] list :cells){
            for (Cell c :list){
                c.update();
            }
        }
    }

    public void updateLoop(int cycles){
        for (int i = 0; i < cycles; i++){
            observe();
            interact();
            update();
            time++;
        }
        notifySubscribers();
    }

    public void repopulate(boolean random){
        for (Cell[] list :cells){
            for (Cell c :list){
                c.reset(random);
            }
        }
    }

    public int getDim(){
        return dim;
    }
}