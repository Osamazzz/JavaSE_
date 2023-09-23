package Learning.File;

import org.junit.Test;

import java.io.*;

/**
 * 让文件恢复时能还原成对象,即要保存值和数据类型(序列化)
 * 要序列化的类需要实现serializable
 * 被transient和static修饰的成员不会被序列化
 */
public class ObjectIOStream {
    public static void main(String[] args) {

    }

    // 序列化
    @Test
    public void test01() {
        // 序列化后保存的文件格式不是txt，而是dat
        String filePath = "d:\\FileTest\\data.dat";
        ObjectOutputStream objectOutputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            // 会自动将数据类型转为包装类
            objectOutputStream.writeInt(100);
            objectOutputStream.writeBoolean(true);
            objectOutputStream.writeChar('a');
            objectOutputStream.writeDouble(9.5);
            objectOutputStream.writeUTF("林永浩");
            // 该类注意要实现序列化
            objectOutputStream.writeObject(new Dog("wangcai", 10));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException E) {
                    E.printStackTrace();
                }
            }
        }
    }

    // 反序列化
    @Test
    public void test02() throws IOException{
        String filePath = "d:\\FileTest\\data.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
        // 读取
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        Object obj = null;
        try {
            obj = ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (obj != null) {
            System.out.println(obj.getClass());
        }
        System.out.println(obj);

        ois.close();

    }

}

class Dog implements Serializable {
    private String name;
    private int age;
    public Dog(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}