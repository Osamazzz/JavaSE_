package Learning.Map_;

import java.util.HashMap;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class Map_Methods {
    public static void main(String[] args) {
        //Map接口常用方法
        HashMap hashMap = new HashMap();
        //put：添加元素
        hashMap.put("abc", "123");//add
        hashMap.put("abc", "456");//替换
        hashMap.put("john", "456");
        System.out.println(hashMap);
        //remove：根据键删除映射关系
        hashMap.remove("abc");
        System.out.println(hashMap);
        System.out.println(hashMap.get("john"));//根据键获得值
        System.out.println(hashMap.size());//获取元素个数
        System.out.println(hashMap.isEmpty());//判断是否为空
        hashMap.clear();//清空
        System.out.println(hashMap);
        System.out.println(hashMap.containsKey("abc"));//查找键是否存在


    }
}
