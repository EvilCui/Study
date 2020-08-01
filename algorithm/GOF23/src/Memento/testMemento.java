package Memento;

public class testMemento {
    public static void main(String[] args){
    Originator o = new Originator();
    CareTaker c = new CareTaker();
    o.init();
    o.show();
    c.setMementor(o.save());
    o.change();
    o.show();
    o.recovery(c.getMementor());
    o.show();
    }
}
