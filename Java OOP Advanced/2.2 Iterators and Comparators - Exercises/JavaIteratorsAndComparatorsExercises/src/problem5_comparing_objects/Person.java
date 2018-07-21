package problem5_comparing_objects;

public class Person implements Comparable<Person>{
    private String name;
    private Integer age;
    private String town;

    public Person(String name, Integer age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public String getTown() {
        return this.town;
    }

    @Override
    public int compareTo(Person person) {
        if(this.getName().compareTo(person.getName()) == 0){
            if(this.age.equals(person.getAge())){
                return this.getTown().compareTo(person.getTown());
            }
            return this.age - person.getAge();
        }
        return this.getName().compareTo(person.getName());
    }
}
