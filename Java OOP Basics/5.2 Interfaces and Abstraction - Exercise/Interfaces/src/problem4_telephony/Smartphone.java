package problem4_telephony;

public class Smartphone implements Browsable, Callable {
    public Smartphone() {
    }

    @Override
    public void browse(String url) {
        for (char c : url.toCharArray()) {
            if(Character.toString(c).matches("[0-9]+")){
                throw new IllegalArgumentException("Invalid URL!");
            }
        }
        System.out.printf("Browsing: %s!%n", url);
    }
    @Override
    public void call(String number) {
        for (char c : number.toCharArray()) {
            if(!Character.toString(c).matches("[0-9]+")){
                throw new IllegalArgumentException("Invalid number!");
            }
        }
        System.out.println("Calling... " + number);
    }
}
