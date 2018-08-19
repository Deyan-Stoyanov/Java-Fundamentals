package callofduty.domain.missions;

public class SurveillanceMission extends BaseMission {
    public SurveillanceMission(String id, Double rating, Double bounty) {
        super(id, rating, bounty);
    }

    @Override
    public Double getBounty() {
        return super.getBounty() + ((super.getBounty() * 50) / 100);
    }

    @Override
    public Double getRating() {
        return super.getRating() - ((super.getRating() * 75) / 100);
    }
}
