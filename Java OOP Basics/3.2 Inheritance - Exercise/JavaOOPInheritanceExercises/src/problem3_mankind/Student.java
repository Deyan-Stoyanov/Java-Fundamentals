package problem3_mankind;

public class Student extends Human {
    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    protected String getFacultyNumber() {
        return facultyNumber;
    }

    private void setFacultyNumber(String facultyNumber) {
        if(!facultyNumber.matches("[0-9A-Za-z]{5,10}")){
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        return String.format("First Name: %s%nLast Name: %s%nFaculty number: %s",
                this.getFirstName(), this.getLastName(), this.getFacultyNumber());
    }
}
