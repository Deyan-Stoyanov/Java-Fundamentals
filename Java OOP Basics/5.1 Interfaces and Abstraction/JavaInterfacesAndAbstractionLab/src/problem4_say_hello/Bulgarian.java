package problem4_say_hello;

public class Bulgarian implements Person{
    private String name;

    public Bulgarian() {
    }

    public Bulgarian(String name) {
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
        return "Здравей";
    }
}
