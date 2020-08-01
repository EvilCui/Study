package FlyWeight;

/**
 * 具体享元角色
 */
public class ConcreteFlyweight implements Flyweight{
    private String key;

    public ConcreteFlyweight(String key) {
        this.key = key;
    }

    @Override
    public void operation(UnSharedConcreteFlyweight state) {
        System.out.println("具体享元"+key+"被调用");
        System.out.println("非享元角色"+state.getInf());
    }
}
