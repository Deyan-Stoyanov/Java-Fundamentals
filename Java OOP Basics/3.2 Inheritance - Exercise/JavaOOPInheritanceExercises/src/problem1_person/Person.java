package problem1_person;

public class Person {

    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.setName(name);
        this.setAge(age);
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() < 3){
            throw new IllegalArgumentException("Name's length should not be less than 3 symbols!");
        }
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if(age < 1){
            throw new IllegalArgumentException("Age must be positive!");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d",
                this.getName(),
                this.getAge());

    }

}
