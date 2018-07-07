package problem8_military_elite.implementations;

import problem8_military_elite.abstract_classes.Soldier;

public class Spy extends Soldier {
    private String codeNumber;

    public Spy(Integer id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d%nCode Number: %s", this.getFirstName(), this.getLastName(), this.getId(), this.getCodeNumber());
    }
}
