package generic_;

import java.util.ArrayList;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class Generic02 {
    public static void main(String[] args) {
        // 泛型又称为参数化类型，用于解决数据类型的安全性问题
        // 在类声明或实例化时只要指定好需要的具体的类型即可
        // 泛型可以保证如果程序在编译时没有发出警告，
        // 运行时就不会产生类型转换异常.提高了代码的健壮性
        // 对于arraylist-> public class ArrayList<E> {}，E为泛型
        // 下面相当于把Animal赋给了E
        ArrayList <Animal> arrayList = new ArrayList<>();
        Animal<String> abc = new Animal<>("abc");
        abc.f();
        // 可以用下面这么理解Animal
//        class Animal {
//            String s;//E表示s的数据类型，该数据类型在定义Animal对象时指定，即在编译时就指定了E是什么类型
//
//            public Animal(String s) {
//                this.s = s;
//            }
//            public String f() {
//                return s;
//            }
//        }
        // 在给泛型指定类型后，可以传入该类型或者该类型的子类
        Animal<A> aAnimal = new Animal<>(new A());
        Animal<B> bAnimal = new Animal<>(new B());
        System.out.println(aAnimal.getClass());
        System.out.println(bAnimal.getClass());
        aAnimal.f();
        bAnimal.f();
        // 如果按下面这么写，就默认是Object类型
        Animal animal = new Animal(new Object());
//      相当于Animal<Object> objectAnimal = new Animal<Object>(new Object());
    }
}
// 可以在类声明时通过一个标识表示某个类中的某个属性的类型
// 或是某个方法的返回值的类型，或是参数类型
class Animal<E> {
    E s;//E表示s的数据类型，该数据类型在定义Animal对象时指定，即在编译时就指定了E是什么类型

    public Animal(E s) {//E也可以为参数类型
        this.s = s;
    }
    public E f() {//返回类型用E
        System.out.println(s.getClass());//s的运行类型
        return s;
    }
}

class A {}
class B extends A {}
