package problem3_mankind;

public class Human {
    private String firstName;
    private String lastName;

    public Human() {
    }

    public Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    protected String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        if(!firstName.matches("[A-Z][0-9A-Za-z]+")){
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }
        if(firstName.length() < 4){
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }
        this.firstName = firstName;
    }

    protected String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(!lastName.matches("[A-Z][0-9A-Za-z]+")){
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }
        if(lastName.length() < 3){
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }
        this.lastName = lastName;
    }
}
