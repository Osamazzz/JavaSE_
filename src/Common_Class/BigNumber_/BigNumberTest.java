package Common_Class.BigNumber_;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class BigNumberTest {
    public static void main(String[] args) {
        //BigInteger和BigDecimal类
        //需要处理很大的整数时，long不够用
        //可以使用BigInteger类
//        long l = 237999999999999999999999;
        BigInteger bigInteger = new BigInteger("237999999999999999999999");
        System.out.println(bigInteger);
        //在对biginteger进行加减乘除时需要使用对应方法
        BigInteger bigInteger1 = new BigInteger("3");
        System.out.println(bigInteger.add(bigInteger1));//加
        System.out.println(bigInteger.subtract(bigInteger1));//减
        System.out.println(bigInteger.multiply(bigInteger1));//乘
        System.out.println(bigInteger.divide(bigInteger1));//除
        System.out.println();
        //BigDecimal类:保存一个精度很高的小数
        double d = 1999.1111111111111111111111111111111;//精度丢失
        System.out.println(d);
        BigDecimal bigDecimal = new BigDecimal("1999.11111111111");
        System.out.println(bigDecimal);
        //在对bigDecimal进行加减乘除时需要使用对应方法
        BigDecimal bigDecimal1 = new BigDecimal("1.3");
        System.out.println(bigDecimal.add(bigDecimal1));//加
        System.out.println(bigDecimal.subtract(bigDecimal1));//减
        System.out.println(bigDecimal.multiply(bigDecimal1));//乘
        //除->可能抛出ArithmeticException异常，指定精度即可解决
//        System.out.println(bigDecimal.divide(bigDecimal1));
        //如果有无限循环小数，就会保留被除数的精度
        System.out.println(bigDecimal.divide(bigDecimal1, BigDecimal.ROUND_CEILING));
    }
}
