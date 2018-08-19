package callofduty.factories;

import callofduty.domain.agents.MasterAgent;
import callofduty.domain.agents.NoviceAgent;
import callofduty.interfaces.Agent;
import callofduty.util.Config;

public final class AgentFactory {
    private AgentFactory(){}

    public static Agent createAgent(String id, String name){
        return new NoviceAgent(id, name, Config.NOVICE_AGENT_START_RATING);
    }

    public static Agent createAgent(String id, String name, Double rating){
        return new MasterAgent(id, name, rating, Config.MASTER_AGENT_START_BOUNTY);
    }
}
