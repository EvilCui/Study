package FlyWeight;

/**
 * 抽象享元角色，非享元角色作为参数引用
 */
public interface Flyweight {
    public void operation(UnSharedConcreteFlyweight state);
}
