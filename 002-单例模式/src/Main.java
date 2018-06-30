import java.util.Scanner;

/**
 * Author: 刘俊重
 * Time: 2018-06-30
 */
public class Main {

    /**
     * 使用双检锁创建线程安全的单例模式
     */
    public static class Singleton1{
        private static volatile Singleton1 single = null;
        private Singleton1(){}

        public static Singleton1 getSingle(){
            if(single==null){
                synchronized (Singleton1.class){
                    if(single==null){
                        single = new Singleton1();
                    }
                }
            }
            return single;
        }
    }

    public static void main(String[] args) {
        System.out.println(Singleton1.getSingle()==Singleton1.getSingle());
    }
}
