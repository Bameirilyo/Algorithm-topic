# 实现Singleton模式

##双重校验锁
```Java
public class Singleton {
     /**
      * 双重校验锁
      * 采用双锁机制，安全、且在多线程环境下能保持高性能
      */
     private volatile static Singleton singleton;
     private Singleton(){}
     public static Singleton getSingleton(){
         if (singleton == null){
             synchronized (Singleton.class){
                 if (singleton == null){
                     singleton = new Singleton();
                 }
             }
         }
         return singleton;
     }
 }
```

##饿汉式
```Java
/**
 * 饿汉式
 *
 * 是否 Lazy 初始化：否
 * 是否多线程安全：是
 * 实现难度：易
 * 描述：这种方式比较常用，但容易产生垃圾对象。
 * 优点：没有加锁，执行效率会提高。
 * 缺点：类加载时就初始化，浪费内存。
 */
class Singleton01{
    private static Singleton01 instance = new Singleton01();
    private Singleton01(){}
    public static Singleton01 getInstance(){
        return instance;
    }
}
```

##懒汉式
```Java
/**
 * 懒汉式，线程安全
 *
 * 优点：第一次调用才初始化，避免内存浪费。
 * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
 */
class Singleton02 {
    private static Singleton02  instance;
    private Singleton02 (){}
    public static synchronized Singleton02  getInstance() {
        if (instance == null) {
            instance = new Singleton02 ();
        }
        return instance;
    }
}
```