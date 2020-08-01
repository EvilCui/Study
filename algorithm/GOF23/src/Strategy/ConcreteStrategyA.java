package Strategy;

public class ConcreteStrategyA implements Strategy {
    @Override
    public void strategyMethod() {
        System.out.println("访问具体策略A");
    }
}
