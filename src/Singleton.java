import javax.xml.crypto.dsig.SignedInfo;

public class Singleton {

    /**
     * 懒汉式单例、饿汉式单例、登记式单例
     * 单例类的特点：（1）单例类只能有一个实例（2）单例类必须自己创建唯一的实例（3）单例类必须给所有其它对象提供这一实例
     */

// ----------------------------------------------------------------------------------------------------------------------

    //饿汉式单例，在类初始化时，已经自行实例化
    private static final Singleton instance = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return instance;
    }

// ----------------------------------------------------------------------------------------------------------------------

    // 懒汉式单例，在第一次调用的时候实例化自己（以下的实现方式为线程不安全的）
//    private static Singleton instance = null;
//
//    private Singleton() {
//
//    }
//
//    public static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }

// ----------------------------------------------------------------------------------------------------------------------

    // 懒汉式单例，在第一次调用的时候实例化自己（以下的实现方式为线程安全的）

//    private static Singleton instance = null;
//
//    private Singleton() {

//    }

    // 1、在getInstance方法上加同步
//    public static synchronized Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }

    // 2、双重检查锁定
//    public static Singleton getInstance() {
//        if (instance == null) {
//            synchronized (Singleton.class) {
//                if (instance == null) {
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }

    // 3、静态内部类
//    private static class LazyHolder {
//        private static final Singleton INSTANCE = new Singleton();
//    }
//
//    public static final Singleton getInstance() {
//        return LazyHolder.INSTANCE;
//    }

// ----------------------------------------------------------------------------------------------------------------------

}
