package Common_Class.Math_;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class Math01 {
    public static void main(String[] args) {
        //Math类内一般是静态方法
        //常用方法
        System.out.println(Math.abs(-9));//绝对值
        System.out.println(Math.pow(2.0, 4.0));//求幂，2的4次方
        System.out.println(Math.ceil(-3.001));//向上取整，返回>=改参数的最小整数
        System.out.println(Math.floor(-3.001));//向下取整
        System.out.println(Math.round(-5.401));//四舍五入
        System.out.println(Math.sqrt(-9));//开方，负数不报错，返回NaN
        System.out.println(Math.random());//随机数0<= x <1
        for (int i = 0; i < 10; i++) {
//            返回2-7随机整数
            int j = 2 + (int) ((5+1) * Math.random());
            System.out.print(j + " ");
        }
        System.out.println();
        System.out.println(Math.max(40, 90));//最大值
        System.out.println(Math.min(40, 90));//最小值
    }
}
