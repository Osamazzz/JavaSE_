package August;
//单例设计模式
public class singletonTest {
    public static void main(String[] args){
       People1 people1 = People1.getPeople();
       People1 people2 = People1.getPeople();
       System.out.println(people1 == people2);//可以看到两个对象指向同一个地址

        People2 people3 = People2.getPeople();
        People2 people4 = People2.getPeople();
        System.out.println(people3 == people4);
    }
}
//饿汉实现
class People1{

    //私有化构造器
    private People1(){

    }
    //构造私有的对象，要求此对象是静态的
    private static People1 people1 = new People1();//直接创建对象，虽然占用内存时间过长。但是是线程安全的
    //提供一个公共的静态方法，返回私有类的对象
    public static People1 getPeople(){
        return people1;
    }
}
//懒汉式
class People2{
    //私有化构造器
    private People2(){

    }
    //构造私有的对象，要求此对象是静态的
    private static People2 people2 = null;
    //提供一个公共的静态方法，返回私有类的对象
    public static People2 getPeople(){
        if(people2 == null){//要调用这个方法时才创建对象，节省内存
            people2 = new People2();
        }
        return people2;
    }
}
