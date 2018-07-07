package problem8_military_elite.abstract_classes;

public abstract class Soldier {
    private Integer id;
    private String firstName;
    private String lastName;

    protected Soldier(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId(){
        return this.id;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
}
