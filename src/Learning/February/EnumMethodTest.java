package Learning.February;

/**
 * @author Obamazzz
 * @version 1.0
 * 枚举类的常用方法
 */
public class EnumMethodTest {
    public static void main(String[] args) {
        //使用Season02枚举类
        Season02 season1 = Season02.SPRING;
        System.out.println(season1.name());
        System.out.println(season1.ordinal());//输出枚举对象的次序/编号，从0开始
        //javap后可以看到values方法返回Season02[]
        //即含有定义的所有枚举对象
        Season02[] season02 = season1.values();
        //使用foreach循环，冒号左边声明的类型要和需要遍历的对象的类型一致
        for (Season02 season: season02) {
            System.out.print(season + " ");
        }
        System.out.println();
        //valueOf方法:将字符串转换为枚举对象，要求字符串必须为已有的常量名，否则报错
        Season02 autumn02 = Season02.valueOf("AUTUMN");
        Season02 autumn03 = Season02.AUTUMN;
        System.out.println(autumn03 == autumn02);
        //compareTo方法:把Season02.AUTUMN与Season02.SPRING枚举对象的编号进行比较
        //相等返回0，不相等返回Season02.AUTUMN的枚举编号减去Season02.SPRING的枚举编号
        System.out.println(Season02.AUTUMN.compareTo(Season02.SPRING));
    }
}
