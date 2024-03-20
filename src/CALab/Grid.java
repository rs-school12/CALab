package CALab;

import mvc.Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class Grid extends Model {

    public static int time = 0;
    public static int dim = 20;

    protected Cell[][] cells;

    public abstract Cell makeCell();

    public Grid(int dim){
        Grid.dim = dim;
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
                cells[i][j].setLocation(i,j);
            }
        }

        SetCellNeighbors();
    }

    private void SetCellNeighbors(){
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

//                System.out.println("cell: " + cells[i][j].row + " " + cells[i][j].col);
//                for (Cell c :cells[i][j].neighbors){
//                    System.out.println(c.row + " " + c.col);
//                }

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
        observe();
        for(int cycle = 0; cycle < cycles; cycle++) {
            interact();
            update();
            observe();
            time++;
            System.out.println("time = " + time);
        }
        changed();
        notifySubscribers();
    }

    public void repopulate(boolean random){
        for (Cell[] list :cells){
            for (Cell c :list){
                c.reset(random);
            }
        }
        time = 0;
        observe();
        changed();
    }

    public Cell[][] getCells() {
        return cells;
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        for (Cell[] list :cells){
            for (Cell c :list){
                c.setMyGrid(this);
                c.neighbors = new ArrayList<>();
            }
        }

        SetCellNeighbors();
    }

}