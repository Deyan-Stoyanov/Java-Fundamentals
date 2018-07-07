package problem5_say_hello_extend;

public class European extends BasePerson implements Person{

    public European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
