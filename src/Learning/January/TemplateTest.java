package Learning.January;

public class TemplateTest {
    public static void main(String[] args) {
        Template01 template01 = new Template01();
        template01.caleTimes();
    }
}
//模板设计模式
abstract class Template {
    public abstract void code();//需要子类补充的抽象方法
    public void caleTimes() {//模板
        long start = System.currentTimeMillis();
        code();//实现动态绑定机制，绑定子类实例的内存地址，找到子类重写的code方法
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start) + "ms");
    }
}

class Template01 extends Template {
    @Override
    public void code() {//子类补充抽象方法code()

    }
}