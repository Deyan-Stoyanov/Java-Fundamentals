package callofduty.domain.missions;

public class HuntMission extends BaseMission {
    public HuntMission(String id, Double rating, Double bounty) {
        super(id, rating, bounty);
    }

    @Override
    public Double getBounty() {
        return super.getBounty() + ((super.getBounty() * 100) / 100);
    }

    @Override
    public Double getRating() {
        return super.getRating() + ((super.getRating() * 50) / 100);
    }
}
