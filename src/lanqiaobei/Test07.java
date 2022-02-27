package lanqiaobei;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class Test07 {
    public static void main(String[] args) {
//        小蓝准备用 256MB 的内存空间开一个数组，
//        数组的每个元素都是 32 位 二进制整数，
//        如果不考虑程序占用的空间和维护内存需要的辅助空间，
//        请问 256MB 的空间可以存储多少个 32 位二进制整数？32=4字节
        int space = 256 * 1024 * 1024;
        System.out.println(space / 4);

    }
}
