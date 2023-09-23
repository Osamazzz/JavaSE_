package Learning.Collection_.Collections_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class Collections01 {
    public static void main(String[] args) {
        //Collections类中提供了很多静态方法
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("4567");
        list.add("7891011");
        System.out.println("list=" + list);
        Collections.reverse(list);//反转元素集合
        System.out.println("list=" + list);
        Collections.shuffle(list);//对集合元素随机排序
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list,new Comparator<String>() {//自定义排序
            @Override
            public int compare(String o1, String o2) {
                //
                return o1.length() - o2.length();
            }
        });
        System.out.println(list);
        Collections.swap(list, 0, 1);//交换
        System.out.println(list);
        Collections.max(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        ArrayList<String> des = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            des.add("");
        }
        Collections.copy(des, list);//拷贝，新集合size要比旧的大
        //把所有123换成hhh
        Collections.replaceAll(des, "123", "hhh");
        System.out.println(des);
    }
}
