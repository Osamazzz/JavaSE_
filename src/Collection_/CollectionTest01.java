package Collection_;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class CollectionTest01 {
    public static void main(String[] args) {
        //集合主要是两种:单列集合和双列集合
        //Collection接口下有两个重要的子接口:List和Set,他们的实现子类都是单列集合
        //Map接口的实现类是双列集合，存放Key-Value
//        ArrayList arrayList = new ArrayList();
//        arrayList.add("tom");
//
//        HashMap hashMap = new HashMap();
//        hashMap.put("N01", "Beijing");

        List list = new ArrayList();
        list.add(10);//list.add(new Integer(10));
        list.add(true);//添加
        list.add(true);
        list.add("Tom");
        list.remove(true);//删除元素
        System.out.println(list);
        System.out.println(list.contains("jack"));//查找元素是否存在
        System.out.println(list.size());//获取元素个数
        System.out.println(list.isEmpty());//判断是否为空
        list.clear();//清空元素
        System.out.println(list);
        ArrayList list2 = new ArrayList();
        list2.add("jack");
        list2.add("tom");
        list.addAll(list2);//添加多个元素
        System.out.println(list);
        System.out.println(list.containsAll(list2));//查找多个元素
        list.removeAll(list2);
        System.out.println(list);//删除多个元素
    }
}
