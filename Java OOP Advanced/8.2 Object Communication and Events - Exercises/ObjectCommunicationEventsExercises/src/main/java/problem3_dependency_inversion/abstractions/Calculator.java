package problem3_dependency_inversion.abstractions;

public interface Calculator {
    void changeStrategy(char operator);

    int performCalculation(int firstOperand, int secondOperand);
}
