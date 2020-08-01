package Visitor;

public class ConcreteVisitorA implements  Visitor{
    @Override
    public void visit(ConcreteElementA concreteElementA) {
        System.out.println("具体访问者A--"+concreteElementA.operationA());
    }

    @Override
    public void visit(ConcreteElementB concreteElementB) {
        System.out.println("具体访问者B--"+concreteElementB.operationB());
    }
}
