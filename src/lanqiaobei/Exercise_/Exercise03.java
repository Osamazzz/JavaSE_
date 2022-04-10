package lanqiaobei.Exercise_;

import java.util.*;

/**
 * @author Obamazzz
 * @version 1.0
 * 你有一架天平和 N 个砝码，这 N 个砝码重量依次是 W1,W2,⋅⋅⋅,WN。
 * 请你计算一共可以称出多少种不同的正整数重量？
 * 注意砝码可以放在天平两边。
 * 输入格式
 * 输入的第一行包含一个整数 N。
 * 第二行包含 N 个整数：W1,W2,W3,⋅⋅⋅,WN。
 */
public class Exercise03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a;
        Set<Integer> set = new HashSet<Integer>();    //用来去重
        List<Integer> list;                            //用来遍历，不能直接遍历set
        //因为在遍历的过程中要往set增加
        set.add(sc.nextInt());
        while (n-- > 1) {
            a = sc.nextInt();
            list = new ArrayList<>(set);
            for (Integer in : list) {                //遍历前面的种类，与新加入的砝码组合
                if (in != a) //防止相减时出现0
                    set.add(Math.abs(in - a));
                set.add(in + a);
            }
            set.add(a);
        }
        System.out.println(set.size());

    }

}
