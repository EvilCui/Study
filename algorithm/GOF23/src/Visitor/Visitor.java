package Visitor;

/**
 * 抽象操作数据结构中的元素
 */
public interface Visitor {
    void visit(ConcreteElementA concreteElementA);
    void visit(ConcreteElementB concreteElementB);
}
