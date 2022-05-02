package Learning.Map_;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class Map01 {
    public static void main(String[] args) {
        // Map与Collection并列存在,用于保持具有映射关系的数据:key-Value
        // Map中的key和value可以是任何引用类型的数据，会封装到HashMap$Node对象中
        // Map中的key不允许重复，和hashset类似，value则可以重复
        // Map的key可以为null，value也可以为null，但key为空只能有一个，value可以有多个null
        // 实际开发中常用String作为Map的key
        // key和value之间存在单向一对一的关系,即通过指定的key总能找到相应的value
        Map map = new HashMap();
        map.put("No.1","abc");//key-value
        map.put("No.2","def");
        map.put("No.1","zzz");//遇到相同的k，就会发生替换，zzz替换掉abc
        map.put(null, null);
        map.put(null, "abc");
        System.out.println(map);//无序的
        // get方法传入一个key返回相应的value
        System.out.println(map.get(null));
        // 一对k-v是放在一个Node中的，又Node实现了Entry接口，因此一对kv也是一个entry
        // k-v为了方便进行遍历，还会创建EntrySet集合，该集合存放的元素的类型为Entry
        // 而一个Entry对象就有K，V，实际上这里的k和v只是指向了node的k和v，并不是存放
        // EntrySet中定义的类型是Map.Entry，但实际上存放的还是HashMap$Node
        // HashMap$Node实现了Map.Entry接口,Map.Entry提供了两个重要方法：getValue和getKey
        Set set = map.entrySet();//注意entrySet方法返回的是Set接口类型
        System.out.println(set.getClass());//HashMap$EntrySet
        for (Object obj : set) {
//            System.out.println(obj.getClass());//HashMap$Node
            //为了从HashMap$Node中取出k-v
            //向下转型
            Map.Entry entry1 = (Map.Entry) obj;
            System.out.println(entry1.getKey() + "-" + entry1.getValue());

        }
        // 还可以将k和v单独取出，封装到实现了set接口的类和实现了collection接口的类中，方便单独遍历
        Set set1 = map.keySet();
        System.out.println(set1);
        Collection values = map.values();
        System.out.println(values);

        System.out.println(set1.getClass());
        System.out.println(values.getClass());
    }
}


