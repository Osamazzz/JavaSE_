package Learning.January;

import java.util.Scanner;

public class MethodTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        fibonacci fibonacci = new fibonacci();
        do {
            System.out.println("请输入一个整数:");
            int inInt = in.nextInt();
            int num1 = fibonacci.fibonacci(inInt);
            if (num1 == -1) {
                System.out.println("请输入大于等于1的整数！");
            } else {
                System.out.println(inInt + "的斐波那契数为:" + num1);
                break;
            }
        } while (true);
    }
}

class fibonacci {
    public int fibonacci(int n) {
        if (n >= 1) {
          if (n == 1 || n == 2){
              return 1;
          } else {
              return fibonacci(n - 1) + fibonacci(n - 2);
          }
        } else {
            return -1;
        }
    }
}