package problem3_dependency_inversion.strategies;

import problem3_dependency_inversion.abstractions.Strategy;

public class DivisionStrategy implements Strategy {
    @Override
    public int calculate(int firstOperand, int secondOperand) {
        if(secondOperand == 0){
            throw new UnsupportedOperationException("Division by zero not allowed");
        }
        return firstOperand / secondOperand;
    }
}
