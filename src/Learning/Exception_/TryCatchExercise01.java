package Learning.Exception_;

import java.util.Scanner;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class TryCatchExercise01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int inInt = 0;
        while (true) {
            System.out.println("请输入一个整数:");
            try {
                inInt = Integer.parseInt(in.next());//这里可能出现异常
                break;
            } catch (NumberFormatException e) {
                System.out.println("输入错误,请重新输入!");
                in.nextLine();//清空输入缓存区
            }
        }
        System.out.println("inInt = " + inInt);
    }
}
