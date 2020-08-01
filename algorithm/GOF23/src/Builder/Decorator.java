package Builder;

/**
 * 建造者模式
 * 装修客厅
 */
public abstract class Decorator {
    protected Product parlour = new Product();
    public abstract void buildWall();
    public abstract void buildTV();
    public abstract void buildSofa();
    public Product getResult(){
        return parlour;
    }
}
