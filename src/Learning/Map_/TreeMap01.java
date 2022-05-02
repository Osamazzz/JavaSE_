package Learning.Map_;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class TreeMap01 {
    public static void main(String[] args) {
        // 和treeSet一样，使用无参构造器时元素是无序的

        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //调用String的compareTo方法
//                return ((String) o2).compareTo((String) o1);
                // 按照长度排序
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        map.put("jack", "杰克");
        map.put("joh", "约翰");
        map.put("mk", "麦克");
        map.put("smith", "史密斯");
        System.out.println(map);

    }
}
