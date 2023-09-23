package newStart;

public class Test16 {
    public static void main(String[] args) {
        BB bb = new BB();

    }


}

class AA {
    static {
        System.out.println("static AA");
    }

    {
        System.out.println("!static AA");
    }

    public AA() {
        System.out.println("AA");
    }
}

class BB extends AA {
    static {
        System.out.println("static BB");
    }

    {
        System.out.println("!static BB");
    }

    public BB() {
        System.out.println("BB");
    }
}