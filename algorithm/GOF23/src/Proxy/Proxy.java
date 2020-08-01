package Proxy;

public class Proxy implements Specialty {

    private ChangZhouSpecialty realObject = new ChangZhouSpecialty();

    public void price(){
        System.out.println("2元/斤,");
    }

    public void number(){
        System.out.println("买10斤");
    }

    @Override
    public void show() {
        price();
        number();
        realObject.show();
    }
}
