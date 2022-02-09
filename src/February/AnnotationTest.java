package February;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class AnnotationTest {
    public static void main(String[] args) {
        Student student = new Student();
        student.run();
    }
}

class People {
    //在{“”}中写你要忽略的警告信息
    //@SuppressWarnings作用域与放置的位置有关，比如在People类中则作用域为People类
    //该注解类有数组String[] values()
    @SuppressWarnings({"all"})
    public void say() {
        System.out.println("人可以说话");
    }
}
@Deprecated
class Student extends People {
    //@Override注解：放在say方法上，表示子类重写了父类的say方法
    //加上@Override后编译器会检查say是否真的重写了，如果的确重写则编译通过
    @Override
    public void say() {
        System.out.println("学生可以说话");;
    }
    @Deprecated
    //用于表示某个程序元素（类、方法等）已经过时,不推荐使用但仍然可以使用
    //用于进行新旧版本的过渡
    public void run(){

    }
}