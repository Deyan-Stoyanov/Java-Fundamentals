package exam_preparation_1.entities.cells.classes;

import exam_preparation_1.entities.cells.abstractions.BloodCell;

public class WhiteBloodCell extends BloodCell {
    private int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        this.setSize(size);
    }

    public int getSize() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    @Override
    public int getEnergy() {
        return (this.getHealth() + this.getSize()) * 2;
    }

    @Override
        public String toString() {
        return super.toString() + String.format("%n--------Health: %s | Size: %d | Energy: %d", this.getHealth(), this.getSize(), this.getEnergy());
        }
}
