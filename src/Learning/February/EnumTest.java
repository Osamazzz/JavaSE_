package Learning.February;

/**
 * @author Obamazzz
 * @version 1.0
 * 演示enum关键字使用
 */

public class EnumTest {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN);

        System.out.println(Season02.SPRING);//调用父类Enum的toString方法
        System.out.println(Season.SPRING);

    }
}

//自定义枚举类
class Season {
    private String name;
    private String desc;//描述
    //定义了四个final对象
    public final static Season SPRING = new Season("春天", "温暖");
    public final static Season WINTER = new Season("冬天", "寒冷");
    public final static Season SUMMER = new Season("夏天", "炎热");
    public final static Season AUTUMN = new Season("秋天", "凉爽");

    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

//枚举类
enum Season02 {
    //将定义的常量声明在最前面,多个常量用,分割
    SPRING("春天", "温暖"),
    WINTER("冬天", "寒冷"),
    SUMMER("夏天", "炎热"),
    AUTUMN("秋天", "凉爽");
    private String name;
    private String desc;//描述

    //private可以省略，枚举类构造器默认是私有的
    Season02(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season02{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}