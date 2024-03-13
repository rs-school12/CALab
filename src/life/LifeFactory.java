package life;

import CALab.Cell;
import CALab.Grid;
import CALab.GridFactory;

public class LifeFactory extends GridFactory {
    public Grid makeModel() {
        return new Society();
    }


}
