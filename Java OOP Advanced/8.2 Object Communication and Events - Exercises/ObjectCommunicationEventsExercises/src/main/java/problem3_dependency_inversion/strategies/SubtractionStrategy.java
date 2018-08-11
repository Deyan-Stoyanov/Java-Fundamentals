package problem3_dependency_inversion.strategies;

import problem3_dependency_inversion.abstractions.Strategy;

public class SubtractionStrategy implements Strategy {

    @Override
    public int calculate(int firstOperand, int secondOperand){
        return firstOperand - secondOperand;
    }
}
