package exam_preparation_2.entities.races;

import exam_preparation_2.entities.cars.Car;

public class TimeLimitRace extends Race {
    private int goldTime;
    public TimeLimitRace(int length, String route, int prizePool, int goldTime) {
        super(length, route, prizePool);
        this.goldTime = goldTime;
    }

    public int getGoldTime() {
        return goldTime;
    }

    private void setGoldTime(int goldTime) {
        this.goldTime = goldTime;
    }

    @Override
    public void addParticipant(Car participant) {
        if(this.getParticipants().isEmpty()){
            super.addParticipant(participant);
        }
    }

    public int getPrize(){
        if(this.getParticipants().get(0).getTimePerformance(this.getLength()) <= this.goldTime){
            return this.getPrizePool();
        } else if(this.getParticipants().get(0).getTimePerformance(this.getLength()) <= (this.goldTime + 15)){
            return  this.getPrizePool() / 2;
        }
        return ((this.getPrizePool() * 30) / 100);
    }

    public String getEarnedTime(){
        if(this.getParticipants().get(0).getTimePerformance(this.getLength()) <= this.goldTime){
            return "Gold";
        } else if(this.getParticipants().get(0).getTimePerformance(this.getLength()) <= (this.goldTime + 15)){
            return "Silver";
        }
        return "Bronze";
    }
}
