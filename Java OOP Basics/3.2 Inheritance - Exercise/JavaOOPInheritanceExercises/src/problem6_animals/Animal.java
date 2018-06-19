package problem6_animals;

public abstract class Animal {
    private String name;
    private Integer age;
    private String gender;

    public Animal() {
    }

    public Animal(String name, Integer age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.isEmpty() || name.matches("\\s+")){
            throw new InvalidInputException();
        }
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if(age < 0){
            throw new InvalidInputException();
        }
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")){
            throw new InvalidInputException();
        }
        this.gender = gender;
    }

    public String produceSound(){
        return ("Not implemented!");
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append(this.getName()).append(" ")
                .append(this.getAge()).append(" ")
                .append(this.getGender())
                .append(System.lineSeparator())
                .append(this.produceSound());
        return sb.toString();
    }
}
