package Learning.Collection_.List;

import java.util.Vector;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class VectorTest01 {
    public static void main(String[] args) {
//        Vector底层也是一个对象数组，protected Object[] elementData；
//        Vector是线程同步的，即线程安全，Vector类的方法有关键字synchronized
//        开发中需要线程同步安全时需要考虑使用Vector
        Vector vector = new Vector(8,9);
//        创建Vector如果是无参构造器,容量默认按照10给
//        满了之后就默认按照两倍扩容(可以通过修改capacityIncrement来改变扩容的大小)
//        capacityIncrement默认为0，若不指定则扩默认两倍(通过有参构造器修改)
//        修改后可以按照指定的大小扩容(不是指定倍数)
//        如果是调用有参构造器，每一次扩容也是按照两倍扩容
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
    }
}
