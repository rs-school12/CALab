package CALab;

import mvc.Model;
import mvc.View;

import javax.swing.*;
import java.awt.*;

public class GridView extends View {

    private CellView cellViews[][];

    public GridView(Grid model) {
        super(model);

        cellViews = new CellView[Grid.dim][Grid.dim];
        /*
        Cell cell = new CellView(((Grid)model).getCell(row, col)
        cellViews[row][col] = cell
        set cell.row and cell.col here
        */
        this.setLayout(new GridLayout(Grid.dim,Grid.dim));
        for (int i = 0; i < Grid.dim; i++){
            for (int j = 0; j < Grid.dim; j++){
                CellView cellView = new CellView(model.cells[i][j]);
                cellViews[i][j] = cellView;
                this.add(cellView);
                cellView.update();
            }
        }
    }

    @Override
    public void setModel(Model model) {
        super.setModel(model);
        for (int i = 0; i < cellViews.length; i++){
            for (int j = 0; j < cellViews[0].length;j++){
                cellViews[i][j].SetCell(((Grid)model).getCells()[i][j]);
                cellViews[i][j].update();
            }
        }
        repaint();
    }
}