package app.entities.powers;

public class Power implements SuperPower {
    private String name;
    private double powerPoints;

    public Power(String name, double powerPoints) {
        this.setName(name);
        this.setPowerPoints(powerPoints);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if(!name.matches("@[a-zA-Z_]{3,}@")){
            throw new IllegalArgumentException("Super power name not in the correct format!");
        }
        this.name = name;
    }

    public double getPowerPoints() {
        return this.powerPoints + (this.getName().length() / 2);
    }

    public void setPowerPoints(double powerPoints) {
        if(powerPoints <= 0){
            throw new IllegalArgumentException("Power points should be a positive number!");
        }
        this.powerPoints = powerPoints;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
