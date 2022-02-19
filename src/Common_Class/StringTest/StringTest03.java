package Common_Class.StringTest;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class StringTest03 {
    public static void main(String[] args) {
        //String类的intern方法最终返回的是常量池的地址
        //在方法区的常量池中创建了两个字符串对象，并没有修改abc
        String s1 = "abc";
        s1 = "123";
        //创建一个对象
        String s2 = "hello" + "efg";//编译器会优化等价为“helloefg”

        String a = "john";
        String b = "smith";
        // 会先创建一个StringBuilder对象
        // 然后执行append方法
        // 最后执行toString方法->会在堆中new一个对象
        // 最终其实是c指向堆中对象，对象中的value再指向常量池的"johnsmith"
        String c = a + b;
        String d = "johnsmith";
        System.out.println(c == d);//false
        int i = 9654;
        int qian = i / 1000;
        int bai = (i - 1000 * qian) / 100 ;
        int shi = (i / 10) % 10;
        int ge = i % 10;
        System.out.println(qian +" "+bai +" "+ shi +" "+ ge);
    }
}
