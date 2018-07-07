package problem4_say_hello;

public class European implements Person{
    private String name;

    public European() {
    }

    public European(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name){
        this.name = name;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
