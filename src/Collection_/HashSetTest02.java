package Collection_;

import java.util.HashSet;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class HashSetTest02 {
    public static void main(String[] args) {
        // 第一次添加时table数组扩容到16,
        // 临界值(threshold)为16*加载因子(loadFactor=0.75)=12
        // 如果table的size(结点数并不只是指table数组中各个索引的第一个元素，而是所有的结点的个数，包括链表上的结点)
        // 到了12,就会扩容两倍到32,临界值变为24,以此类推
        // HashSet添加一个元素时，先得到一个hash值，转换成索引值
        HashSet set = new HashSet();
        // 然后找到数据存储表table,看这个索引位置是否已经存放了元素
        // 没有则直接添加,如果有则调用equals方法进行比较(看具体的类的equals方法)
        // 如果equals方法返回true则放弃添加，否则以链表形式进行添加
        set.add("abc");//debugger一下,看源码
        set.add("def");
        //String类重写了equals方法,比较的是内容,因此再次添加abc会失败
        set.add("abc");
        System.out.println(set);
        // Java8中如果一条链表的元素个数>=TREEIFY_THRESHOLD(默认为8)
        // 且table大小>=64,就会进行树化(红黑树)
        // 只满足元素个数>=TREEIFY_THRESHOLD，则先会对table进行扩容，
        // 直到table大小>=64,才会进行树化
        // 否则仍然采用数组扩容机制
    }
}
