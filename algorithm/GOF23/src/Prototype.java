/**
 * 原型
 */
public class Prototype implements Cloneable{
    private String name;
    private int age;
    private String gender;

    public Prototype(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Prototype clone() throws CloneNotSupportedException{
        System.out.println("拷贝");
        return (Prototype) super.clone();
    }
}
