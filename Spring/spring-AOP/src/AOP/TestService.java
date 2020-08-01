package AOP;

public class TestService implements TestServiceInter,TestServiceInter2{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sayHi() {
        System.out.println("hi "+name);
    }

    @Override
    public void sayBye() {
        System.out.println("bye "+name);
    }
}
