package callofduty.domain.agents;

import callofduty.interfaces.BountyAgent;

public class MasterAgent extends BaseAgent implements BountyAgent {
    private Double bounty;

    public MasterAgent(String id, String name, Double rating, Double bounty) {
        super(id, name, rating);
        this.bounty = bounty;
    }

    @Override
    public Double getBounty() {
        return this.bounty;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%nBounty Earned: $%.2f",
                this.getBounty());
    }

    private void setBounty(Double bounty) {
        this.bounty = bounty;
    }

    private void increaseBounty(Double bounty){
        this.bounty += bounty;
    }
}
