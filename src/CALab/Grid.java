package CALab;

import mvc.Model;

import java.util.ArrayList;
import java.util.List;

public abstract class Grid extends Model {
    private int time = 0;
    private int dim = 20;

    private List<List<Cell>> cells = new ArrayList<>();

    public abstract Cell makeCell();

    public void observe(){
        for (List<Cell> list :cells){
            for (Cell c :list){
                c.observe();
            }
        }
    }

    public void interact(){
        for (List<Cell> list :cells){
            for (Cell c :list){
                c.interact();
            }
        }
    }

    public void update(){
        for (List<Cell> list :cells){
            for (Cell c :list){
                c.update();
            }
        }
    }
}
