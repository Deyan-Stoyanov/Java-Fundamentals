package exam_preparation_1.entities.cells.classes;

import exam_preparation_1.entities.cells.abstractions.Microbe;

public class Fungi extends Microbe {
    public Fungi(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }


    @Override
    public int getEnergy() {
        return (this.getHealth() + this.getVirulence()) / 4;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%n--------Health: %s | Virulence: %d | Energy: %d", super.getHealth(), super.getVirulence(), this.getEnergy());
    }
}
