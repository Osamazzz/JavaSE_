package Learning.Common_Class.StringTest;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class StringTest02 {
    public static void main(String[] args) {
        // String的字符使用Unicode字符编码，一个字符(不区分是字母还是汉字)占两个字节
        // String类实现了Serializable接口，可以串行化，说明string可以在网络中传输
        // String有很多构造器，实现了构造器的重载
        // 方式一是在堆中创建空间，里面维护了value属性，指向常量池123的空间，
        // 如果没有则在常量池中创建，如果有，直接通过value指向常量池，但s1最终指向堆中的空间地址
        // 方式二是先从常量池中查看是否有123数据空间，有则直接指向，没有则重新创建，
        // 然后指向，s2最终指向的是常量池的空间地址
        String s1 = new String("123");//方式一：调用构造器
        String s2 = "123";//方式二：直接赋值
        String s3 = "123";
        System.out.println(s1 == s2);//false
        System.out.println(s2 == s3);//true
        // String类有属性private final char value[];用于存放字符串内容
        // value是一个final类型，不是value[](数组)，而value为引用，
        // 这代表value的地址不可改，但是value数组的内容可改
        final char value[] = {'a', 'b'};
        char[] v2 = {'t', 'o', 'm'};
        value[0] = 'H';//可以修改
        //value = v2;//error!
    }
}
