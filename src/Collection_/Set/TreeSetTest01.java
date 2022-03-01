package Collection_.Set;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class TreeSetTest01 {
    public static void main(String[] args) {
        // 当我们使用无参构造器创建treeSet时，它是无序的
        // 当希望添加的元素是按照字符串大小来排序的
        // 使用treeSet提供的一个构造器，可以传入一个比较器(匿名内部类)，指定排序规则
        //
        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //调用String的compareTo方法
//                return ((String) o2).compareTo((String) o1);
                // 按照长度排序
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        set.add("jack");
        set.add("tom");
        set.add("yh");
        set.add("a");
        set.add("a");//添加失败
        set.add("abc");//失败
        System.out.println(set);
    }
}
