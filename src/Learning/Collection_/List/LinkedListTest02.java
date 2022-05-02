package Learning.Collection_.List;

import java.util.LinkedList;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class LinkedListTest02 {
    public static void main(String[] args) {
//        LinkedList的CRUD(增删改查)
        LinkedList list = new LinkedList();
        //添加结点
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("list =" + list);
        //删除结点
        list.remove();//默认删除第一个
        System.out.println("list =" + list);
        //修改结点
        list.set(0, 999);
        System.out.println("list =" + list);
        //得到结点
        Object obj = list.get(0);
        System.out.println(obj);
     }
}
