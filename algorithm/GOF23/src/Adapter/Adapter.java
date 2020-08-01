package Adapter;

public class Adapter implements Target{
    private Adaptee adaptee;

    public Adapter(){
        adaptee = new Adaptee();
    }

    @Override
    public void driver() {
        adaptee.show();
    }

    public void print(){
        System.out.println("电压适配器");
    }
}
