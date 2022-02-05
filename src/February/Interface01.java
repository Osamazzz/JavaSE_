package February;

public interface Interface01 {
    //规定接口的相关方法
    //在接口中，抽象方法可以省略abstract关键字
    public void start();
    public void stop();
    //JDK8以后可以有默认实现方法，但需使用default关键字
    default public void ok() {
        System.out.println("OK");
    }
    //也可以有静态方法
     public static void ok2() {
         System.out.println("ok2");
     }
}
