package CALab;

import mvc.*;
import stoplight.Stoplight;

public class GridFactory implements AppFactory {
    //public Model makeModel() { return new Grid(); } //different per implementation

    @Override
    public Model makeModel() {
        return new Grid() {
            @Override
            public Cell makeCell() {
                return null;
            }
        };
    }

    public View makeView(Model m) {
        return new GridView((Grid)m);
    }



    public String[] getEditCommands() { return new String[] {"Run1", "Run50", "Populate", "Clear"}; }

    // source added 3/15 to support text fields
    public Command makeEditCommand(Model model, String type, Object source) {
        if (type.equals("Run1"))
            return new RunCommand(model, type);
        if (type.equals("Run50"))
            return new RunCommand(model, type);
        if (type.equals("Populate"))
            return new PopulateCommand(model);
        if (type.equals("Clear"))
            return new ClearCommand(model);
        return null;
    }

    public String getTitle() { return "CALab Simulator"; }

    public String[] getHelp() {
        return new String[] {"RUN1: calls grid.updateLoop(1)",
        "RUN50: calls grid.updateLoop(50)",
       "POPULATE: calls grid.repopulate() which sets the state of each cell to a random value",
        "CLEAR: calls grid.clear() which sets the state of each cell to an initial value"};
    }

    public String about() {
        return "CALab Simulator version 1.0. Copyright 2023.";
    }

}
