package Map_;

import java.util.*;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class Map02 {
    public static void main(String[] args) {
        //Map遍历方式
        HashMap map = new HashMap();
        map.put("smith", "123");
        map.put("john", "456");
        map.put("mike", "789");
        //第一种：先取出所有key，通过key取出对应value
        Set keySet = map.keySet();
        //增强for
        for (Object key : keySet) {
            System.out.println(key + "-" + map.get(key));
        }
        System.out.println();
        //迭代器
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object key =  iterator.next();
            System.out.println(key + "-" + map.get(key));
        }
        System.out.println();
        //第二种：把所有values取出
        Collection values = map.values();
        //增强for
        for (Object o : values) {
            System.out.println(o);
        }
        System.out.println();
        //迭代器
        iterator = values.iterator();
        while (iterator.hasNext()) {
            Object value =  iterator.next();
            System.out.println(value);
        }
        System.out.println();
        //第三种：通过EntrySet来获取key-value
        Set entrySet = map.entrySet();//EntrySet<Map.Entry<K,V>>
        //增强for
        for (Object entry : entrySet) {
            //将entry转成Map.Entry
            Map.Entry m = (Map.Entry) entry;//entrySet存放的是Map.Entry
            System.out.println(m.getKey() + "-" + m.getValue());
        }
        System.out.println();
        //迭代器
        iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            //向下转型
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

    }
}
