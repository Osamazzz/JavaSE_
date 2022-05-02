package Learning.Exception_;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class ExceptionTest {
    public static void main(String[] args) {

        int n1 = 100;
        int n2 = 0;
        //抛出ArithmeticException异常
        //抛出异常后程序就会退出，下面的代码不再执行
        //int res = n1 / n2;
        //当一段代码可能出现异常，
        //可以采用try-catch异常处理机制来保证程序的健壮性
        //如果进行了异常处理，那么即使出现了异常，程序也可以继续执行
        try {
            int res = n1 / n2;
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("出现的异常为:" + e.getMessage());//输出异常信息
        }
        System.out.println("程序运行中。。。。");
    }
}