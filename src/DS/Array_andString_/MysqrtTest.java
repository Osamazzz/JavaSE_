package DS.Array_andString_;

/**
 * @author Obamazzz
 * @version 1.0
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 */
public class MysqrtTest {
    public static void main(String[] args) {
        System.out.println(new MysqrtTest().mySqrt(36));
    }

    public int mySqrt(int x) {
        if (x < 2){
            return x;
        }
        int low = 1, high = x;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid  == x/mid) {
                return mid;
            } else if (mid  < x/mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}
