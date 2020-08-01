package Factory;

public class Sheep implements Animal {

    public Sheep(){ }

    @Override
    public void show() {
        System.out.println("羊");
    }
}
