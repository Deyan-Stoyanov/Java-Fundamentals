package exam_preparation_1.entities.cells.abstractions;

public abstract class Cell {
    private String id;
    private int health;
    private int positionRow;
    private int positionCol;

    public Cell(String id, int health, int positionRow, int positionCol) {
        this.setId(id);
        this.setHealth(health);
        this.setPositionRow(positionRow);
        this.setPositionCol(positionCol);
    }

    public String getId() {
        return this.id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public int getHealth() {
        return this.health;
    }

    private void setHealth(int health) {
        this.health = health;
    }

    public int getPositionRow() {
        return this.positionRow;
    }

    private void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    public int getPositionCol() {
        return this.positionCol;
    }

    private void setPositionCol(int positionCol) {
        this.positionCol = positionCol;
    }

    public abstract int getEnergy();

    public void increaseHealth(int health) {
        this.setHealth(this.getHealth() + health);
    }

    public void setNewCoordinates(int newRow, int newCol) {
        this.setPositionRow(newRow);
        this.setPositionCol(newCol);
    }

    public void takeDamage(int damage) {
        this.setHealth(this.getHealth() - damage);
    }

    @Override
    public String toString() {
        return String.format("------Cell %s [%d,%d]", this.getId(), this.getPositionRow(), this.getPositionCol());
    }
}