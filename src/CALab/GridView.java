package CALab;

import mvc.Model;
import mvc.View;

import javax.swing.*;
import java.awt.*;

public class GridView extends View {

    private CellView cellViews[][];

    public GridView(Grid model) {
        super(model);
        /*
        Cell cell = new CellView(((Grid)model).getCell(row, col)
        cellViews[row][col] = cell
        set cell.row and cell.col here
        */
        this.setLayout(new GridLayout(model.getDim(),model.getDim()));
        for (int i = 0; i < model.getDim(); i++){
            for (int j = 0; j < model.getDim(); j++){
                CellView cellView = new CellView(model.cells[i][j]);
                this.add(cellView);
            }
        }
    }

}