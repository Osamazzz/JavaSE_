package Common_Class.StringTest;

import java.util.Scanner;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class StringBuffer02 {
    public static void main(String[] args) {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);//没有报错
        System.out.println(sb.length());
//        StringBuffer sb2 = new StringBuffer(null);//空指针异常
        Scanner in = new Scanner(System.in);
        String price = "1235644545454562.59";
        StringBuffer sb2 = new StringBuffer(price);
//        int i = sb2.indexOf(".");//找到小数点索引
        for (int i = sb2.lastIndexOf(".") - 3; i > 0; i -= 3) {
            sb2 = sb2.insert(i, ",");//每隔三位插入
        }
        System.out.println(sb2);//1,235,644,545,454,562.59
    }
}
