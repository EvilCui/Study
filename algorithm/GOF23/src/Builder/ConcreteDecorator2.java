package Builder;

public class ConcreteDecorator2 extends Decorator {

    @Override
    public void buildWall() {
        parlour.setWall("w2");
    }

    @Override
    public void buildTV() {
        parlour.setTV("t2");
    }

    @Override
    public void buildSofa() {
        parlour.setSofa("s2");
    }
}
