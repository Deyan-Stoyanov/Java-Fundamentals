package callofduty.domain.agents;

import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseAgent implements Agent {
    private String id;
    private String name;
    private Double rating;
    private List<Mission> missions;
    private int completedMissionCount;

    protected BaseAgent(String id, String name, Double rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.missions = new ArrayList<>();
    }

    @Override
    public void acceptMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public void completeMissions() {
        Double bounty = 0D;
        for (Mission mission : missions) {
            this.rating += mission.getRating();
            bounty += mission.getBounty();
            try {
                Method method = mission.getClass().getSuperclass().getDeclaredMethod("setStatus");
                method.setAccessible(true);
                method.invoke(mission);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        this.completedMissionCount += this.missions.size();
        if(this instanceof MasterAgent){
            try {
                Method increaseBounty = this.getClass().getDeclaredMethod("increaseBounty", Double.class);
                increaseBounty.setAccessible(true);
                increaseBounty.invoke(this, (Object)bounty);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        this.missions = new ArrayList<>();
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getRating() {
        return this.rating;
    }

    @Override
    public String toString() {
        return String.format("%s Agent - %s%n" +
                "Personal Code: %s%n" +
                "Assigned Missions: %d%n" +
                "Completed Missions: %d%n" +
                "Rating: %.2f",
                this.getClass().getSimpleName().substring(0, this.getClass().getSimpleName().indexOf("Agent")),
                this.getName(),
                this.getId(),
                this.missions.size(),
                this.completedMissionCount,
                this.getRating());
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setRating(Double rating) {
        this.rating = rating;
    }

    private void setCompletedMissionsCount(int count){
        this.completedMissionCount = count;
    }
}
