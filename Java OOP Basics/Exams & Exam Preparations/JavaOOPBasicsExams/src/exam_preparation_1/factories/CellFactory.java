package exam_preparation_1.factories;

import exam_preparation_1.entities.cells.abstractions.Cell;
import exam_preparation_1.entities.cells.classes.*;

public final class CellFactory {
    private CellFactory(){}

    public static Cell createCell(String type, String cellId, int health, int positionRow, int positionCol, int additionalProperty){
        Cell cell = null;
        switch (type){
            case "RedBloodCell":
                cell = createRedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "WhiteBloodCell":
                cell = createWhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "Virus":
                cell = createVirus(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "Fungi":
                cell = createFungi(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "Bacteria":
                cell = createBacteria(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            default:
                break;
        }
        return cell;
    }

    public static RedBloodCell createRedBloodCell(String cellId, int health, int positionRow, int positionCol, int additionalProperty){
        return new RedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
    }

    public static WhiteBloodCell createWhiteBloodCell(String cellId, int health, int positionRow, int positionCol, int additionalProperty){
        return new WhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
    }

    public static Bacteria createBacteria(String cellId, int health, int positionRow, int positionCol, int additionalProperty){
        return new Bacteria(cellId, health, positionRow, positionCol, additionalProperty);
    }

    public static Virus createVirus(String cellId, int health, int positionRow, int positionCol, int additionalProperty){
        return new Virus(cellId, health, positionRow, positionCol, additionalProperty);
    }

    public static Fungi createFungi(String cellId, int health, int positionRow, int positionCol, int additionalProperty){
        return new Fungi(cellId, health, positionRow, positionCol, additionalProperty);
    }
}
