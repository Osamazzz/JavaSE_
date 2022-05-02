package Learning.Common_Class.Wrapper_;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class Integer02 {
    public static void main(String[] args) {
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        System.out.println(i1 == i2);//false
        Integer i3 = 1;//底层并不是直接new一个对象，而是使用valueOf方法
        Integer i4 = 1;
        System.out.println(i3 == i4);//true
        // valueOf方法中若数字在-128到127之间，并不是直接new一个Integer
        // 而是返回一个已经有了的对象（从数组返回）->看Integer的valueOf方法源码
        Integer i5 = 128;//不在范围内，直接new一个新对象
        Integer i6 = 128;//不同的对象
        System.out.println(i5 == i6);//false

        Integer integer = 127;
        int i7 = 127;;
        // 只要有基本数据类型参与，那么判断的是值是否相同
        System.out.println(i7 == integer);//true
    }
}
