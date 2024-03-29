package CALab;

import mvc.Command;
import mvc.Model;

public class RunCommand extends Command {
    private Model model;
    private String type;

    public RunCommand(Model model, String type) {
        super(model);
        this.model = model;
        this.type = type;
    }

    public void execute() {
        if (type == "Run50"){
            ((Grid) model).updateLoop(50);
        }else{
            ((Grid) model).updateLoop(1);
        }
    }
}
