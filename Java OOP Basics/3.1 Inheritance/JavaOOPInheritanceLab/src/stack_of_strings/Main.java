package stack_of_strings;

public class Main {
    public static void main(String[] args) {
        StackOfStrings stack = new StackOfStrings();
        stack.push("Pesho");
        stack.push("Gosho");
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
