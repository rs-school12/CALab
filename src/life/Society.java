package life;

import CALab.Cell;
import CALab.Grid;

public class Society extends Grid {
    public Society(){this(20);}
    public Society(int dim) {
        super(dim);
    }

    @Override
    public Cell makeCell() {
        return new Agent(this);
    }
}
