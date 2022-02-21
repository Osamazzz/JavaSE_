package Common_Class.Arrays_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class ArraysExercise01 {
    public static void main(String[] args) {
        Book_[] books = new Book_[4];
        books[0] = new Book_("红楼梦", 100);
        books[1] = new Book_("水浒传aa", 90);
        books[2] = new Book_("三国演义", 5);
        books[3] = new Book_("西游记zzz", 300);
        bubbleSort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1;//前
                Integer i2 = (Integer) o2;//后
                return i2 - i1;//后减前大于0交换，降序
            }
        });
        for (Object o : books){
            System.out.println(o);
        }
        System.out.println("==============");
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book_ book1 = (Book_) o1;//前
                Book_ book2 = (Book_) o2;//后
                return book1.price - book2.price;//前减后大于0交换，升序
            }
        });
        for (Object o : books){
            System.out.println(o);
        }
        System.out.println("==============");
        bubbleSort02(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1;//前
                Integer i2 = (Integer) o2;//后
                return i1 - i2;//前减后大于0交换，升序
            }
        });
        for (Object o : books){
            System.out.println(o);
        }

    }
    public static void bubbleSort(Book_[] arr, Comparator comparator) {
        Book_ temp;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                //数组排序方式由下面这个方法返回的值来决定
                if (comparator.compare(arr[j].price, arr[j + 1].price) > 0) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    //按照书名长度排序
    public static void bubbleSort02(Book_[] arr, Comparator comparator) {
        Book_ temp;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                //数组排序方式由下面这个方法返回的值来决定
                if (comparator.compare(arr[j].name.length(), arr[j + 1].name.length()) > 0) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
class Book_ {
    public String name;
    public int price;

    public Book_(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book_{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
