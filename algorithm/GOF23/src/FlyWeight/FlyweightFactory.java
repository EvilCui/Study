package FlyWeight;

import java.util.HashMap;

/**
 * 享元工厂
 */
public class FlyweightFactory {
    private HashMap<String,Flyweight> flyweights = new HashMap<String,Flyweight>();
    public Flyweight getFlyweight(String key){
        Flyweight flyweight = (Flyweight) flyweights.get(key);
        if(flyweight!=null){
            System.out.println("具体享元"+key+"已存在并获取");
        }else{
            flyweight = new ConcreteFlyweight(key);
            flyweights.put(key,flyweight);
        }
        return flyweight;
    }
}
