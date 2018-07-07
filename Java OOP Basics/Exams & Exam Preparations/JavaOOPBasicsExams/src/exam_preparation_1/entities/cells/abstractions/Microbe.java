package exam_preparation_1.entities.cells.abstractions;

public abstract class Microbe extends Cell{
    private int virulence;

    public Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.setVirulence(virulence);
    }

    public int getVirulence() {
        return this.virulence;
    }

    private void setVirulence(int virulence) {
        this.virulence = virulence;
    }
}
