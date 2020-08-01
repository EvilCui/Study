package Factory;

public class Pig implements Animal {

    public Pig(){}

    @Override
    public void show() {
        System.out.println("猪");
    }
}
