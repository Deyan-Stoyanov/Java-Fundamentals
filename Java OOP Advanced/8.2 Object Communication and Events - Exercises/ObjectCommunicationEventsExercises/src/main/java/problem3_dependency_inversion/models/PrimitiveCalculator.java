package problem3_dependency_inversion.models;

import problem3_dependency_inversion.abstractions.Calculator;
import problem3_dependency_inversion.abstractions.Strategy;
import problem3_dependency_inversion.managers.StrategyManager;
import problem3_dependency_inversion.strategies.AdditionStrategy;

public class PrimitiveCalculator implements Calculator {

    private Strategy strategy;

    public PrimitiveCalculator() {
        this.strategy = new AdditionStrategy();
    }

    @Override
    public void changeStrategy(char operator) {
        this.strategy = StrategyManager.createStrategy(operator);
    }

    @Override
    public int performCalculation(int firstOperand, int secondOperand) {
        return this.strategy.calculate(firstOperand, secondOperand);
    }
}
