package problem6_animals;

public class InvalidInputException extends IllegalArgumentException {
    public InvalidInputException() {
        super("Invalid input!");
    }
}
