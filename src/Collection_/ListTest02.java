package Collection_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class ListTest02 {
    public static void main(String[] args) {
        //list三种遍历方式
        List list = new ArrayList();
        list.add("tom");
        list.add("jack");
        list.add("john");
        //1.迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            System.out.println("obj=" + obj);
        }
        System.out.println("=======================");
        //2.增强for
        for (Object o : list) {
            System.out.println("obj=" + o);
        }
        System.out.println("=======================");
        //3.普通for
        for (int i = 0; i < list.size(); i++) {
            System.out.println("obj=" + list.get(i));
        }
    }
}
