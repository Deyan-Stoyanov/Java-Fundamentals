package exam_preparation_2.entities.races;

public class CircuitRace extends Race{
    private int laps;

    public CircuitRace(int length, String route, int prizePool, int laps) {
        super(length, route, prizePool);
        this.laps = laps;
    }

    public int getLaps() {
        return laps;
    }

    private void setLaps(int laps) {
        this.laps = laps;
    }
}
