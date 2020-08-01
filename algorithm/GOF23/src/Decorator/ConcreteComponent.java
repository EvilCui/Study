package Decorator;

public class ConcreteComponent implements Component {
    public ConcreteComponent() {
        System.out.println("创建具体构建");
    }

    @Override
    public void Operation() {
        System.out.println("调用具体构建的方法Operation");
    }
}
