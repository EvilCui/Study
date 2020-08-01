package Builder;

public class ConcreteDecorator1 extends Decorator {
    @Override
    public void buildWall() {
        parlour.setWall("w1");
    }

    @Override
    public void buildTV() {
        parlour.setTV("t1");
    }

    @Override
    public void buildSofa() {
        parlour.setSofa("s1");
    }
}
