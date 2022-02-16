package Collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class CollectionTest02 {
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add(new Book("三国演义", "", 10.1));
        col.add(new Book("红楼梦", "曹雪芹", 34.6));
        System.out.println(col);
        //遍历col集合
        //得到col的迭代器
        Iterator iterator = col.iterator();
        //itit快速生成,ctrl+J可查
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println("obj=" + next);
        }
        // 退出while后，next指向最后元素
        // 如果希望再次迭代，需重置迭代器
        iterator = col.iterator();
        //增强for循环，底层仍然是迭代器，可以理解为简化版的迭代器,可用I快速生成
        for (Object book : col) {
            System.out.println(book);
        }
    }
}
class Book {
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
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
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
