package exam_08_03_2017;

public class Dog extends Animal {
    private int commandsAmount;

    public Dog(String name, int age, int commandsAmount, String adoptionCenterName) {
        super(name, age, adoptionCenterName);
        this.commandsAmount = commandsAmount;
    }

    public int getCommandsAmount() {
        return commandsAmount;
    }

    private void setCommandsAmount(int commandsAmount) {
        this.commandsAmount = commandsAmount;
    }
}
