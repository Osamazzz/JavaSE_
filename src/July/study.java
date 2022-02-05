package July;

import org.junit.Test;

public class study {
    public static void main(String[] args){

   }
   @Test
    public void test(){
        //String类->包装类、基本数据类型
       String str3="123";
       int in3 = Integer.parseInt(str3);
       System.out.println(in3);
        //包装类、基本数据类型->String类
        int in1 = 10;
        Integer integer = in1;
        System.out.println(integer.intValue());
        int in2 = integer;
        String str4 = "" + in1;//""+基本数据类型的方法
        System.out.println(str4);
        String str2 = String.valueOf(in1);//使用String类的valueof方法
        System.out.println(str2);
    }
}
class Order{
    Boolean aBoolean = Boolean.TRUE;
}