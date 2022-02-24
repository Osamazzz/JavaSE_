package Collection_.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class ListExercise01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new myBook("红楼梦", "曹雪芹", 100));
        list.add(new myBook("西游记", "吴承恩", 10));
        list.add(new myBook("水浒传", "施耐庵", 9));
        list.add(new myBook("三国演义", "罗贯中", 80));
        System.out.println("====排序前====");
        for (Object obj : list) {
            System.out.println(obj);
        }
        //对集合进行冒泡排序
        sort(list);
        System.out.println("====排序后====");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            System.out.println(obj);
        }
    }
    public static void sort(List list) {
        int size = list.size();
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                //取出对象,用临时变量保存
                //向下转型
                myBook myBook1 = (myBook) list.get(j);
                myBook myBook2 = (myBook) list.get(j + 1);
                if (myBook1.getPrice() > myBook2.getPrice()) {
                    //使用list的set方法进行交换
                    list.set(j, myBook2);
                    list.set(j + 1, myBook1);
                }
            }
            
        }
    }
}

class myBook {
    private String name;
    private String author;
    private double price;

    public myBook(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "myBook{" +
                "名称='" + name + '\'' +
                ", 作者='" + author + '\'' +
                ", 价格=" + price +
                '}';
    }
}
