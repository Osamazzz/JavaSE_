package Learning.Collection_.Set;

import java.util.LinkedHashSet;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class LinkedHashSet01 {
    public static void main(String[] args) {
        //LinkedHashSet是HashSet的子类
        //LinkedHashSet底层是一个LinkedHashMap，底层维护了一个数组和双向链表
        //它根据元素的hashCode值来决定元素的存储位置，同时使用链表维护元素的次序
        //使得元素看起来是以插入顺序保持的(添加和取出顺序一样)，
        // LinkedHashSet不允许添加重复的元素
        LinkedHashSet set = new LinkedHashSet();
        set.add("AA");
        set.add(8);
        set.add(456);//false
        System.out.println(set);//添加和取出顺序一致
        //说明:在LinkedHashSet中维护了一个hash表和双向链表
        // (LinkedHashSet有头结点head和尾结点tail)，每一个结点都有pre(before)和next(after)属性
        //这样可以形成双向链表，在添加一个元素时先求hash值，然后将添加的元素加入到双向
        //链表->添加到双向尾部（如果已经存在则不添加->HashSet机制类似）
        //第一次添加时直接将数组扩容到16，结点类型是LinkedHashMap$Entry->LinkedHashMap类内部的静态内部类
        //且是HashMap.Node（HashMap$Node）的子类，数组是HashMap$Node[],因此结点可以存放在数组中(多态数组)

    }
}
