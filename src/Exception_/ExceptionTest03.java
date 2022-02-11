package Exception_;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class ExceptionTest03 {
    public static void main(String[] args) {
        try {
            String str = "Obamazzz";
            int a = Integer.parseInt(str);
            System.out.println(a);
        } catch (NumberFormatException e) {
            //可以有多个catch
            //子类异常在前
            System.out.println("异常信息为:" + e.getMessage());
        } catch (Exception e){
            //父类异常在后
            e.printStackTrace();
        } finally {
            //finally代码块无论如何都会被执行
            System.out.println("finally代码块被执行...");
        }
    }
}
