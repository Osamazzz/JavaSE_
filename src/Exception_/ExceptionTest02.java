package Exception_;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class ExceptionTest02 {
    public static void main(String[] args) {
        //空指针异常NullPointerException
//        String name = null;
//        System.out.println(name.length());
        //算术异常ArithmeticException
//        int res = 10 / 0;
        //数组越界异常ArrayIndexOutOfBoundsException
//        int[] arr = {1, 2, 3};
//        for (int i = 0; i <= arr.length; i++) {
//            System.out.println(arr[i]);
//        }
        //ClassCastException类型转换异常
//        A b = new B();
//        B b2 = (B) b;//ok
//        C c = (C) b;//error
        //NumberFormatException数字格式不正确异常
        String name2 = "Obamazzz";
        int a1 = Integer.parseInt(name2);
    }
}

class A{}
class B extends A{}
class C extends A{}