package Common_Class.Arrays_;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class ArraysTest03 {
    public static void main(String[] args) {
        //使用binarySearch需让数组先进行排序
        int[] arr = {1,2,90,123,567};
        Integer[] arr2 = {1,2,90,123,567};
        int index = Arrays.binarySearch(arr, 1);//不存在返回-1
        System.out.println("index = " + index);
        //不存在则返回本应存在的索引+1再取反
        int index2 = Arrays.binarySearch(arr, 568);//本应在index=5处,返回-6
        System.out.println( "index2 = "+index2);
        //拷贝前多少个位置的元素，如果没那么多个元素，则在新数组后面插入null或0
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        System.out.println(Arrays.toString(newArr));
        Integer[] newArr2 = Arrays.copyOf(arr2, arr2.length + 1);
        System.out.println(Arrays.toString(newArr2));
        int[] arr3 = new int[3];
        Arrays.fill(arr3, 99);//用99填充arr3
        System.out.println(Arrays.toString(arr3));

        System.out.println(Arrays.equals(arr, arr));//判断两个数字是否完全一致

        List list =  Arrays.asList(2, 3, 4, 5);//返回一个集合
        //运行类型其实是Arrays类内的一个静态内部类，这个内部类继承了AbstractCollection类
        //因此直接输出这个list时，会调用AbstractCollection类的toString方法
        //而AbstractCollection类的toString方法又类似Arrays类的toString方法->看源码
        System.out.println(list.getClass());

    }
}
