package CALab;

import mvc.Model;
import mvc.Command;

public class ClearCommand extends Command {

    private Model model;

    public ClearCommand(Model model) {
        super(model);
        this.model = model;
    }

    public void execute() {
        /*Grid grid = (Grid) model;
        reset cells;*/
    }
}
