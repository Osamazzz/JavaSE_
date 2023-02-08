package Learning.Exception_;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class TryCatchExercise02 {
    public static void main(String[] args) {
        System.out.println(method());
    }
    public static int method() {
        int i = 1;
        try {
            i++;
            String[] str = new String[3];
            if (str[1].equals("tom")) {
                System.out.println(str[1]);
            } else {
                str[3] = "Obamazzz";
            }
            return 1;
        } catch (NullPointerException e) {
            ++i;
            System.out.println(i);
            return i;//这里先用一个临时的变量temp=i=3，最后才执行return，且return的是temp
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        } finally {//先执行完finally中的语句
            i++;
            System.out.println("i=" + i);
        }
    }
}
