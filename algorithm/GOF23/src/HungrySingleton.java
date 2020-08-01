/**
 * 单例模式 饿汉式，静态初始化
 */
public class HungrySingleton {
    private static  final HungrySingleton instance = new HungrySingleton();
    private HungrySingleton() {};

    public HungrySingleton getInstance(){
        return instance;
    }
}
