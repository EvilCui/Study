package Factory;

public class PigFarm implements Farm {
    @Override
    public Animal newAnimal() {
        Animal pig = new Pig();
        System.out.println("猪诞生了");
        pig.show();
        return pig;
    }
}
