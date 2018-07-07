package exam_preparation_2.entities.cars;

public abstract class Car{
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    public Car(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.horsepower = horsepower;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }

    public String getBrand() {
        return brand;
    }

    private void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    private void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getHorsepower() {
        return horsepower;
    }

    private void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getAcceleration() {
        return acceleration;
    }

    private void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public int getSuspension() {
        return suspension;
    }

    private void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public int getDurability() {
        return durability;
    }

    private void setDurability(int durability) {
        this.durability = durability;
    }

    public String toString() {
        return String.format("%s %s %d%n%d HP, 100 m/h in %d s%n%d Suspension force, %d Durability", this.getBrand(), this.getModel(), this.getYearOfProduction(), this.getHorsepower(), this.getAcceleration(), this.getSuspension(), this.getDurability());
    }

    public void tune(int tuneIndex, String addOn){
        this.setHorsepower(this.getHorsepower() + tuneIndex);
        this.setSuspension(this.getSuspension() + (tuneIndex / 2));
    }

    public int getEnginePerformance(){
        return (horsepower / acceleration);
    }

    public int getSuspensionPerformance(){
        return (suspension + durability);
    }

    public int getOverallPerformance(){
        return this.getEnginePerformance() + this.getSuspensionPerformance();
    }

    public int getPerformancePoints(String type){
        switch (type) {
            case "CasualRace":
            case "CircuitRace":
                return this.getOverallPerformance();
            case "DragRace":
                return this.getEnginePerformance();
            case "DriftRace":
                return this.getSuspensionPerformance();
        }
        return 0;
    }

    public int getTimePerformance(int raceLength){
        return raceLength  * ((this.horsepower / 100) * this.acceleration);
    }

    public void decreaseDurability(int length, int laps){
        for (int i = 0; i < laps; i++) {
            this.durability -= (length * length);
        }
    }
}
