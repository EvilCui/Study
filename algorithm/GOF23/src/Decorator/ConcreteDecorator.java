package Decorator;

public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void Operation(){
        super.Operation();
        addFunction();
    }

    public void addFunction(){
        System.out.println("具体装饰功能");
    }
}

