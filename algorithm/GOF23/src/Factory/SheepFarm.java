package Factory;

public class SheepFarm implements Farm {
    @Override
    public Animal newAnimal() {
        Animal sheep = new Sheep();
        System.out.println("羊诞生了");
        sheep.show();
        return sheep;
    }
}
