package LeetCode_.BitOperation;

/**
 * 位运算
 * @author Obamazzz
 * @version 1.0
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），
 * 返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).
 */
public class hammingWeightTest {
    public static void main(String[] args) {
        System.out.println(9&1);//9%2=1
        System.out.println(8&1);//等价于8%2=0
        int a = 0b11111111111111111111111111111101;
        System.out.println(new hammingWeightTest().hammingWeight(a));
    }
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n = n >>> 1;
        }
        return res;
    }
    //方法二：巧用 n & (n - 1)
    //(n−1) 解析： 二进制数字 n 最右边的 1 变成 0 ，此 1 右边的 0 都变成 1 。
    // 不用一位一位判断，二进制数字 n 最右边的 1 变成 0 ，其余不变
    public int hammingWeight2(int n) {
        int res = 0;
        while(n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }

}
