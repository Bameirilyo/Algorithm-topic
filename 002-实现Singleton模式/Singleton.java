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
