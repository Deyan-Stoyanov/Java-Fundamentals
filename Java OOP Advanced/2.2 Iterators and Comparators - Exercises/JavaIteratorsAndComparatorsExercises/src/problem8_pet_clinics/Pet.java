package problem8_pet_clinics;

public class Pet {
    private String name;
    private int age;
    private String kind;

    public Pet(String name, int age, String kind) {
        this.name = name;
        this.age = age;
        this.kind = kind;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getKind() {
        return this.kind;
    }

    private void setKind(String kind) {
        this.kind = kind;
    }

    @Override
        public String toString() {
            return String.format("%s %d %s", this.getName(), this.getAge(), this.getKind());
        }
}
