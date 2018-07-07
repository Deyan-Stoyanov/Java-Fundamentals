package exam_preparation_1.entities.cells.classes;

import exam_preparation_1.entities.cells.abstractions.BloodCell;

public class RedBloodCell extends BloodCell {
    private int velocity;

    public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
        super(id, health, positionRow, positionCol);
        this.setVelocity(velocity);
    }

    public int getVelocity() {
        return this.velocity;
    }

    private void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    @Override
    public int getEnergy() {
        return this.getHealth() + this.getVelocity();
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%n--------Health: %s | Velocity: %d | Energy: %d", this.getHealth(), this.getVelocity(), this.getEnergy());
    }
}
