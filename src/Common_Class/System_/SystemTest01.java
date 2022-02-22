package Common_Class.System_;

import java.util.Arrays;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class SystemTest01 {
    public static void main(String[] args) {
        //复制数组，比较适合底层调用，我们一般使用Arrays类的copyOf方法
        int[] src = {1, 2, 3};
        int[] des = new int[3];//{0,0,0}
        //源数组，从原数组的哪个索引开始拷贝，目标数组，把源数组的数据拷贝到目标数组的哪个索引，拷贝的长度
        System.arraycopy(src, 0, des, 0, src.length);
        System.out.println(Arrays.toString(des));
        //返回当前时间距离1970-1-1的毫秒数
        long start = System.currentTimeMillis();
        System.out.println(start + "ms");
        //运行垃圾回收机制
//        System.gc();
        //退出程序
//        System.exit(0);//0正常退出
    }
}
