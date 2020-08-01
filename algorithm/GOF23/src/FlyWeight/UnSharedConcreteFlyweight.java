package FlyWeight;

public class UnSharedConcreteFlyweight {
    private String inf;
    UnSharedConcreteFlyweight(String inf){
        this.inf = inf;
    }

    public String getInf() {
        return inf;
    }

    public void setInf(String inf) {
        this.inf = inf;
    }
}
