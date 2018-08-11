package problem1_event_implementation;

public class Handler implements NameChangeListener {

    public void handleNameChange(NameChange event) {
        System.out.println("Dispatcher's name changed to " + event.getChangedName() + ".");
    }
}
