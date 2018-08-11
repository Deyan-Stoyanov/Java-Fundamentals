package problem3_dependency_inversion.managers;

import problem3_dependency_inversion.abstractions.Strategy;
import problem3_dependency_inversion.strategies.AdditionStrategy;
import problem3_dependency_inversion.strategies.DivisionStrategy;
import problem3_dependency_inversion.strategies.MultiplicationStrategy;
import problem3_dependency_inversion.strategies.SubtractionStrategy;

public class StrategyManager {
    public static Strategy createStrategy(char c){
        switch (c){
            case '+':
                return new AdditionStrategy();
            case '-':
                return new SubtractionStrategy();
            case '*':
                return new MultiplicationStrategy();
            case '/':
                return new DivisionStrategy();
        }
        return null;
    }
}
