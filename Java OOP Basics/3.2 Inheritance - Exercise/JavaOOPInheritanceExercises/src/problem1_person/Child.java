package problem1_person;

public class Child extends Person {

    public Child(String name, Integer age) {
        super(name, age);
    }

    @Override
    public void setAge(Integer age) {
        if(age > 15){
            throw new IllegalArgumentException("Child's age must be lesser than 15!");
        }
        super.setAge(age);
    }
}
