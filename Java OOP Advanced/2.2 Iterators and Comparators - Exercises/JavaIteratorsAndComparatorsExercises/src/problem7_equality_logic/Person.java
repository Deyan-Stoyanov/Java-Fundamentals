package problem7_equality_logic;

public class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    private void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.getAge();
        hash = 31 * hash + (name == null ? 0 : name.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }
}
