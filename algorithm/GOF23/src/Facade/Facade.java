package Facade;

/**
 * 外观模式
 */
public class Facade {
    SubSystem1 s1 = new SubSystem1();
    SubSystem2 s2 = new SubSystem2();
    public void show(){
        s1.show();
        s2.show();
    }
}
