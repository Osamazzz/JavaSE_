package lanqiaobei;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class Test03 {
    public static void main(String[] args) {
        // 偶左奇右
        int[][] arr = new int[20][20];
        // i为行,j为列
        int res = 1;
        for (int i = 4, j = 1; j < 20; i += 4, j++) {
            res += i;
        }
        System.out.println(res);
    }
}
