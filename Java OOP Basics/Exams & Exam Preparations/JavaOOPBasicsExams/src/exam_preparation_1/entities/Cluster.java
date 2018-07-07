package exam_preparation_1.entities;

import exam_preparation_1.entities.cells.abstractions.BloodCell;
import exam_preparation_1.entities.cells.abstractions.Cell;

import java.util.LinkedList;
import java.util.List;

public class Cluster {
    private String id;
    private int rows;
    private int cols;
    private Cell[][] cells;

    public Cluster(String id, int rows, int cols) {
        this.setId(id);
        this.setRows(rows);
        this.setCols(cols);
        this.setCells(new Cell[rows][cols]);
    }

    public String getId() {
        return this.id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public int getRows() {
        return this.rows;
    }

    private void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return this.cols;
    }

    private void setCols(int cols) {
        this.cols = cols;
    }

    public Cell[][] getCells() {
        return this.cells;
    }

    private void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public void addCell(Cell cell, int row, int col) {
        if (row >= 0 && col >= 0 && row <= this.getRows() && col <= this.getCols()) {
            this.cells[row][col] = cell;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator()).append("----Cluster ").append(this.getId());
        for (Cell[] cellRow : cells) {
            for (Cell cell : cellRow) {
                if(cell != null){
                    sb.append(System.lineSeparator()).append(cell.toString());
                }
            }
        }
        return sb.toString();
    }

    private Cell fight(Cell startCell, Cell targetCell) {
        String cellType = startCell.getClass().getSimpleName();
        switch (cellType) {
            case "RedBloodCell":
            case "WhiteBloodCell":
                startCell.increaseHealth(targetCell.getHealth());
                startCell.setNewCoordinates(targetCell.getPositionRow(), targetCell.getPositionCol());
                return startCell;
            default:
                while (true) {
                    targetCell.takeDamage(startCell.getEnergy());
                    if (targetCell.getHealth() <= 0) {
                        startCell.setNewCoordinates(targetCell.getPositionRow(), targetCell.getPositionCol());
                        return startCell;
                    }
                    startCell.takeDamage(targetCell.getEnergy());
                    if (startCell.getHealth() <= 0) {
                        targetCell.setNewCoordinates(startCell.getPositionRow(), startCell.getPositionCol());
                        return targetCell;
                    }
                }
        }
    }

    public void activate() {
        List<Cell> cellList = new LinkedList<>();
        for (Cell[] cells : cells) {
            for (Cell cell : cells) {
                if (cell != null) {
                    cellList.add(cell);
                }
            }
        }
        while (cellList.size() > 0) {
            if (cellList.size() == 1) {
                break;
            }
            Cell startCell = cellList.get(0);
            cellList.remove(0);
            Cell secondCell = cellList.get(0);
            cellList.remove(0);
            Cell winner = fight(startCell, secondCell);
            cellList.add(0, winner);
        }
        this.cells = new Cell[rows][cols];
        for (Cell cell : cellList) {
            this.cells[cell.getPositionRow()][cell.getPositionCol()] = cell;
        }
    }

    public int getCellLeft() {
        int cellsLeft = 0;
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getCols(); j++) {
                if(this.getCells()[i][j] != null){
                    cellsLeft++;
                }
            }
        }
        return cellsLeft;
    }
}
