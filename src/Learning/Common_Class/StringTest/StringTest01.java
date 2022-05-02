package Learning.Common_Class.StringTest;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class StringTest01 {
    public static void main(String[] args) {
        //包装类->String
        Integer i = 100;
        String str1 = i + "";//方式1
        String str2 = i.toString();//方式2
        String str3 = String.valueOf(i);//方式3
        //String->包装类
        String str4 = "123456";
        Integer i2 = Integer.parseInt(str4);//使用到自动装箱
        Integer i3 = new Integer(str4);//构造器
    }
}
