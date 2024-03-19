package life;

import CALab.Cell;
import CALab.Grid;

import java.util.*;

public class Society extends Grid {

    public static Set<Integer> rebirth = new HashSet<Integer>();
    public static Set<Integer> death = new HashSet<Integer>();

    public static int percentAlive = 50;

    static {
        rebirth.add(3);
        death.add(0);
        death.add(1);
        death.add(4);
        death.add(5);
        death.add(6);
        death.add(7);
        death.add(8);
    }
    public Society(){this(20);}
    public Society(int dim) {
        super(dim);
    }

    @Override
    public Cell makeCell() {
        return new Agent(this);
    }

    @Override
    public void repopulate(boolean random) {
        if (random) {
            int aliveCount = (int) Math.round((percentAlive / 100.0) * getDim() * getDim());
            List<Integer> selectedNumbers = new ArrayList<>();
            for (int i = 0; i < getDim()*getDim(); i++){
                selectedNumbers.add(i);
            }
            Collections.shuffle(selectedNumbers);
            for (int i = 0; i < selectedNumbers.size(); i++){
                cells[selectedNumbers.get(i) / getDim()][selectedNumbers.get(i) % getDim()].reset(i < aliveCount);
            }

        }else {
            for (Cell[] list : cells) {
                for (Cell c : list) {
                    c.reset(false);
                }
            }
        }
        time = 0;
        observe();
        changed();
    }
}
