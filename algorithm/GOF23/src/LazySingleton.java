/**
 * 单例模式 懒汉式，引用时实例化
 */
public class LazySingleton {
    private static volatile LazySingleton instance = null;//多线程下

    private LazySingleton() {}

    public static synchronized LazySingleton getInstance() {
        if (instance == null)
            instance = new LazySingleton();
        return instance;

    }
}
