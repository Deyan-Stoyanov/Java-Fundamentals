package problem4_mordors_cruelty_plan;

public class Gandalf {
    private Integer happiness;
    private String mood;

    public Gandalf() {
        this.happiness = 0;
    }

    public Gandalf(Integer happiness, String mood) {
        this.happiness = happiness;
        this.mood = mood;
    }

    public Integer getHappiness() {
        return happiness;
    }

    private void setHappiness(Integer happiness) {
        this.happiness = happiness;
    }

    public String getMood() {
        return mood;
    }

    private void setMood() {
        if(this.getHappiness() < -5){
            this.mood = "Angry";
        } else if(this.getHappiness() < 0){
            this.mood = "Sad";
        } else if(this.getHappiness() < 15){
            this.mood = "Happy";
        } else {
            this.mood = "JavaScript";
        }
    }

    public void eat(Food food) {
        switch (food.getName().toLowerCase()) {
            case "cram":
                this.setHappiness(this.getHappiness() + 2);
                break;
            case "lembas":
                this.setHappiness(this.getHappiness() + 3);
                break;
            case "apple":
            case "melon":
                this.setHappiness(this.getHappiness() + 1);
                break;
            case "honeycake":
                this.setHappiness(this.getHappiness() + 5);
                break;
            case "mushrooms":
                this.setHappiness(this.getHappiness() - 10);
                break;
            default:
                this.setHappiness(this.getHappiness() - 1);
                break;
        }
        this.setMood();
    }

    @Override
    public String toString() {
        return this.getHappiness() + System.lineSeparator() + this.getMood();
    }
}
