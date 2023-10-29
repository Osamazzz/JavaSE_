package newStart;

public class Test17 {
    public static void main(String[] args) {
        String abc = "abc";
        String bed = "xyz";
        abc.concat(bed);
        System.out.println(abc);

        String a = new String("abc");
        String b = new String("abc");
        System.out.println(a.equals(b));
        System.out.println(a == b);

    }// caabb

}
