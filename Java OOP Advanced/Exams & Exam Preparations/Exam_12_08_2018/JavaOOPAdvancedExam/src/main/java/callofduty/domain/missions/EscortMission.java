package callofduty.domain.missions;

public class EscortMission extends BaseMission {
    public EscortMission(String id, Double rating, Double bounty) {
        super(id, rating, bounty);
    }

    @Override
    public Double getBounty() {
        return super.getBounty() + ((super.getBounty() * 25) / 100);
    }

    @Override
    public Double getRating() {
        return super.getRating() - ((super.getRating() * 25) / 100);
    }
}
