package callofduty.domain.missions;

import callofduty.interfaces.Mission;

public abstract class BaseMission implements Mission {
    private String id;
    private Double rating;
    private Double bounty;
    private String status = "Open";

    protected BaseMission(String id, Double rating, Double bounty) {
        this.id = id;
        this.rating = rating;
        this.bounty = bounty;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Double getBounty() {
        return this.bounty;
    }

    @Override
    public Double getRating() {
        return this.rating;
    }

    @Override
    public String toString() {
        return String.format("%s Mission - %s%n" +
                "Status: %s%n" +
                "Rating: %.2f%n" +
                "Bounty: %.2f",
                this.getClass().getSimpleName().substring(0, this.getClass().getSimpleName().indexOf("Mission")),
                this.getId(),
                this.status,
                this.getRating(),
                this.getBounty());
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setRating(Double rating) {
        this.rating = rating;
    }

    private void setBounty(Double bounty) {
        this.bounty = bounty;
    }

    private void setStatus(){
        this.status = "Completed";
    }
}
