package google_class;

public class Relative {
    private String name;
    private String birthDate;

    public Relative(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public Relative() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
