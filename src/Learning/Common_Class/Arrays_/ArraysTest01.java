package Learning.Common_Class.Arrays_;

import java.util.*;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class ArraysTest01 {
    public static void main(String[] args) {
        // Arrays类内包含一系列静态方法，用于管理或者操作数组
        int[] arr = {10, 2, 5};
        arr.toString();
        //Arrays类toString方法并没有重写Object的toString
        //它们两个是独立的方法，是重载的关系,就像下面那个类一样
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);//升序排序
        System.out.println(Arrays.toString(arr));
        System.out.println();
        //还可以通过传入一个接口Comparator（实际上是实现一个匿名内部类）来定制排序
        Integer[] arr2 = {1, 2, 5};
        Arrays.sort(arr2, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                return i2 - i1;
            }
        });//降序排序,compare方法返回的结果会直接影响排序的方式
        System.out.println(Arrays.toString(arr2));
    }

}
class Test_ {
    public static String toString(Object obj) {
        return null;
    }
}
