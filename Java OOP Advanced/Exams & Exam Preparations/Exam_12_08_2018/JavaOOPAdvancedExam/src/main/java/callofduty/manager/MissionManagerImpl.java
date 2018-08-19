package callofduty.manager;

import callofduty.domain.agents.MasterAgent;
import callofduty.domain.agents.NoviceAgent;
import callofduty.factories.AgentFactory;
import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;
import callofduty.interfaces.MissionControl;
import callofduty.interfaces.MissionManager;
import callofduty.util.Config;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MissionManagerImpl implements MissionManager {
    private Map<String, Agent> agents;
    private Map<String, Mission> missions;
    private MissionControl control;

    public MissionManagerImpl(MissionControl control) {
        this.agents = new LinkedHashMap<>();
        this.missions = new LinkedHashMap<>();
        this.control = control;
    }

    @Override
    public String agent(List<String> arguments) {
        Agent agent = AgentFactory.createAgent(arguments.get(0), arguments.get(1));
        this.agents.put(agent.getId(), agent);
        return String.format(Config.AGENT_ADDED_MESSAGE, agent.getName(), agent.getId());
    }

    @Override
    public String request(List<String> arguments) {
        Mission mission = this.control.generateMission(arguments.get(1), Double.parseDouble(arguments.get(2)), Double.parseDouble(arguments.get(3)));
        this.missions.put(mission.getId(), mission);
        this.agents.get(arguments.get(0)).acceptMission(mission);
        return String.format(Config.MISSION_ASSIGNED_MESSAGE,
                mission.getClass().getSimpleName().substring(0, mission.getClass().getSimpleName().indexOf("Mission")),
                mission.getId(),
                this.agents.get(arguments.get(0)).getName());
    }

    @Override
    public String complete(List<String> arguments) {
        this.agents.get(arguments.get(0)).completeMissions();
        this.checkAgent(arguments.get(0));
        return String.format(Config.MISSION_COMPLETE_MESSAGE,
                this.agents.get(arguments.get(0)).getName(),
                this.agents.get(arguments.get(0)).getId());
    }

    @Override
    public String status(List<String> arguments) {
        String id = arguments.get(0);
        if(this.agents.containsKey(id)){
            return this.agents.get(id).toString();
        }
        return this.missions.get(id).toString();
    }

    @Override
    public String over(List<String> arguments) {
        int completedMissions = 0;
        for (Mission mission : missions.values()) {
            try {
                Field field = mission.getClass().getSuperclass().getDeclaredField("status");
                field.setAccessible(true);
                String currentMissionStatus = (String) field.get(mission);
                if(currentMissionStatus.equalsIgnoreCase("Completed")){
                    completedMissions++;
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return String.format("Novice Agents: %d%n" +
                        "Master Agents: %d%n" +
                        "Assigned Missions: %d%n" +
                        "Completed Missions: %d%n" +
                        "Total Rating Given: %.2f%n" +
                        "Total Bounty Given: $%.2f",
                this.agents.values().stream().filter(x -> x instanceof NoviceAgent).count(),
                this.agents.values().stream().filter(x -> x instanceof MasterAgent).count(),
                this.missions.size(),
                completedMissions,
                this.agents.values().stream().mapToDouble(Agent::getRating).sum(),
                this.agents.values().stream().filter(x -> x instanceof MasterAgent).map(x -> (MasterAgent)x).mapToDouble(MasterAgent::getBounty).sum()
        );
    }

    private void checkAgent(String agentId) {
        try {
            Field field = this.agents.get(agentId).getClass().getSuperclass().getDeclaredField("completedMissionCount");
            field.setAccessible(true);
            if(((int)field.get(this.agents.get(agentId))) >= 3 && this.agents.get(agentId) instanceof NoviceAgent){
                Agent masterAgent = AgentFactory.createAgent(agentId, this.agents.get(agentId).getName(), this.agents.get(agentId).getRating());
                Method setter = masterAgent.getClass().getSuperclass().getDeclaredMethod("setCompletedMissionsCount", int.class);
                setter.setAccessible(true);
                setter.invoke(masterAgent, (Object)((int)field.get(this.agents.get(agentId))));
                this.agents.remove(agentId);
                this.agents.put(masterAgent.getId(), masterAgent);
            }
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
