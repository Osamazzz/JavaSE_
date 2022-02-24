package Collection_.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class ListTest01 {
    public static void main(String[] args) {
        //List集合类中元素是有序的（添加顺序与取出顺序一致），且可以重复
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        list.add("tom");
        System.out.println("list=" + list);
        //list集合中每个元素都有其对应的顺序索引，即支持索引（从0开始）
        System.out.println(list.get(2));

        //list接口常用方法
        //在index=1插入一个对象
        list.add(1,"john");
        System.out.println(list);
        List list1 = new ArrayList();
        list1.add("张三丰");
        list1.add("贾宝玉");
        list.addAll(1,list1);//在index=1添加一个集合对象
        System.out.println(list);
        System.out.println(list.get(2));//获取指定索引的元素
        System.out.println(list.indexOf("tom"));//返回对象在集合中首次出现的位置
        System.out.println(list.lastIndexOf("tom"));//返回对象在集合中最后出现的位置
        System.out.println(list.remove(5 ));//移除指定索引的元素，返回此元素
        list.set(1,"mary");//设定指定索引元素，相当于更改
        System.out.println(list);
        List list2 = list.subList(1,3);//返回指定范围位置的子集合,但不取最后一个元素
        System.out.println(list2);
        Iterator iterator = list2.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
    }
}
