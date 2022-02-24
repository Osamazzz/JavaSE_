package Collection_.Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class SetTest01 {
    public static void main(String[] args) {
//        Set接口是无序的，即添加和取出的顺序不一致(取出顺序固定)，没有索引
//        不允许元素重复，所以最多包含一个null
        Set set = new HashSet();
        set.add("john");
        set.add("lucy");
        set.add("jack");
        set.add(null);
        set.add(null);
        System.out.println(set);//只有一个null
        // 可以使用迭代器或增强for循环进行遍历,
        // 无法通过索引进行遍历(普通for)
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println("obj = " + next);
        }
        set.remove(null);//删除对象
        System.out.println("=============");
        for (Object o : set) {
            System.out.println("obj = " + o);
        }
    }
}
