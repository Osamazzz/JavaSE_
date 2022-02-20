package Common_Class.StringTest;

import java.util.Locale;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class StringMethod01 {
    public static void main(String[] args) {
        String str = "HelloWorld";
        String str1 = "helloworld";
        // equals方法区分大小写
        System.out.println(str.equals(str1));
        // equalsIgnoreCase方法不区分大小写
        System.out.println(str.equalsIgnoreCase(str1));
        System.out.println(str.length());//获取字符长度
        System.out.println(str.indexOf('l'));//获取第一次出现l的索引，没有则返回-1
        System.out.println(str.lastIndexOf('l'));//获取最后一次出现的索引
        String subStr = str.substring(6);//从索引6开始截取后面的字符
        System.out.println(subStr);
        //截取指定范围的字符，不包括5(最后一个数的索引)
        String subStr1 = str.substring(0,5);
        System.out.println(subStr1);
        System.out.println("hellO".toUpperCase());//HELLO
        System.out.println("HELLO".toLowerCase());//hello
        String str2 = "john smith mike jack john";
        //将字符串中所有的john换为abc，
        // 需要注意的是replace方法执行后，返回的结果才是替换过的
        System.out.println(str2.replace("john","abc"));
        System.out.println(str2);//没有改变
        //split分割字符串
        String poem = "锄禾日当午,汗滴禾下土,谁知盘中餐,粒粒皆辛苦";
        String[] splitPoem = poem.split(",");//以,为分隔符对poem进行分割
        for (String s : splitPoem) {
            System.out.println(s);
        }
        System.out.println("E:\\aaa\\bbb");
        System.out.println("E:\\aaa\\bbb".split("\\\\"));
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            System.out.println(ch);
        }
        //format方法，用法类似c语言中的printf
        String name = "john";
        int age = 18;
        String format = String.format("我的名字是%s,年龄是%d",name, age);
        System.out.println(format);
    }
}
