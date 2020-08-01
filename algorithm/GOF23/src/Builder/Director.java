package Builder;

/**
 * 指挥者
 */
public class Director {
    private Decorator builder;
    public Director(Decorator builder){
        this.builder = builder;
    }

    //组件产品
    public Product decorator(){
        builder.buildTV();
        builder.buildWall();
        builder.buildSofa();
        return builder.getResult();
    }
}
