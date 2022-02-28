package Map_;

import java.util.Hashtable;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class HashTable01 {
    public static void main(String[] args) {
        // hashtable使用方法和hashmap基本一样
        // 但hashtable的K和V不允许为null
        // 但hashtable是线程安全的，hashmap则不是
        // 底层有数组table，为Hashtable$Entry类型，
        // 初始化大小为11，临界值8，threshold为0.75
        // 扩容是先变两倍再加一，即11*2+1=23
        Hashtable table = new Hashtable();
//        table.put(null, 123);空指针异常
        table.put("123", 123);
        System.out.println(table);
    }
}
