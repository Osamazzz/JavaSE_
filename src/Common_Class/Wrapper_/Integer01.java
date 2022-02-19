package Common_Class.Wrapper_;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class Integer01 {
    public static void main(String[] args) {
        //int->Integer装箱与拆箱
        //jdk5以前是手动的
        int n1 = 100;
        Integer integer = new Integer(n1);//装箱
        Integer integer1 = Integer.valueOf(n1);
        System.out.println(integer);
        int n2 = integer.intValue();//手动拆箱
        //jdk5后可以自动装拆箱
        int n3 = 200;
        Integer integer2 = n3;//底层使用Integer.valueOf(n2)
        int n4 = integer2;//底层使用intValue方法

        Object obj1 = true ? new Integer(1) : new Double(2.0);//看作一个整体
        System.out.println(obj1);//输出1.0
    }
}
