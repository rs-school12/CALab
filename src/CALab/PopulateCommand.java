package CALab;

import mvc.Command;
import mvc.Model;
public class PopulateCommand extends Command {
    private Model model;

    public PopulateCommand(Model model) {
        super(model);
        this.model = model;
    }

    public void execute() {
        /*Grid grid = (Grid) model;
        grid.execute();*/
    }
}
