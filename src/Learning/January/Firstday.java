package Learning.January;

import java.util.Scanner;

public class Firstday {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str2 = in.nextLine();
        String str = "123";
        int num1 = Integer.parseInt(str);
        //调用整型的包装类中的parseInt方法
        System.out.println(num1 + 1);
        System.out.println(str.charAt(0));//1
    }
}
