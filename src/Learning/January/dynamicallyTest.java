package Learning.January;

public class dynamicallyTest {
    public static void main(String[] args) {
        d1 a1 = new d2();
        System.out.println(a1.sum1());
        System.out.println(a1.sum2());
    }
}

class d1 {
    int count = 10;
    public int sum1() {
        return geti() + 10;
    }
    public int sum2() {
        return count + 10;
    }
    public int geti() {
        return count;
    }
    
}

class d2 extends d1 {
    int count = 20;
//    public int sum1() {
//        return geti() + 10;
//    }
//    public int sum2() {
//        return count + 10;
//    }
    public int geti() {
        return count;
    }
}