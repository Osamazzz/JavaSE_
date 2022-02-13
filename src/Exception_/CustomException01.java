package Exception_;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class CustomException01 {
    public static void main(String[] args) {
        int age = 180;
        if (!(age >= 18 && age <= 120)) {
            //通过构造器设置错误提示信息
            throw new AgeException("年龄需要在18到120岁之间");
        }
    }
}
//自定义异常一般继承RuntimeException，即运行时异常
//好处是我们可以使用默认的throw处理机制，比较方便
class AgeException extends RuntimeException {
    public AgeException(String message) {
        super(message);
    }
}