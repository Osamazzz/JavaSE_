package lanqiaobei.Exercise_;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class Exercise05 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        long ms = in.nextLong();
        ms -= 8*60*60*1000;
        Date date = new Date(ms);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println(sdf.format(date));
    }
}
