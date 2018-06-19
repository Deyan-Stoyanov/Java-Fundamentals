package animal_farm;

import java.text.DecimalFormat;

public class Chicken {
    private String name;
    private Integer age;
    private Double eggsPerDay;

    public Chicken() {
    }

    public Chicken(String name, Integer age) {
        this.setName(name);
        this.setAge(age);
        this.setEggsPerDay();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name.isEmpty() || name.matches("\\s+")){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    private void setAge(Integer age) {
        if(age < 0 || age > 15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public Double getEggsPerDay() {
        return eggsPerDay;
    }

    private void setEggsPerDay() {
        if(this.age < 6){
            this.eggsPerDay = 2D;
        } else if(this.age < 12){
            this.eggsPerDay = 1D;
        } else {
            this.eggsPerDay = 0.75;
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("Chicken %s (age %d) can produce %s eggs per day.", this.getName(), this.getAge(), df.format(this.getEggsPerDay()));
    }
}
