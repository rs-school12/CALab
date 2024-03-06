package stoplight;

import mvc.Command;
import mvc.Model;

public class ChangeCommand implements Command {

    public ChangeCommand(Model model) {
        super(model);
    }

    public void execute() {
        Stoplight light = (Stoplight)model;
        light.change();
    }

}