package Homework;
/**
 * final关键字可以用来修饰类、对象和属性甚至局部变量
 */

public class FinalTest {

}

//class前面加final意味着不能再有子类
final class finalA{
   //属性前加final为常量
    final int age = 18;
    //方法前加final意味着此方法无法再进行重写

}
class finalB{
    final public void show(){

        }
}
class C extends finalB{
    //无法重写父类中的方法
    //public void show(){

    //}
}

//finalB类无法继承finalA类
//class finalB extends finalA
//{
//}
