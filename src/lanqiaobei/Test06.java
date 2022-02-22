package lanqiaobei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class Test06 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] score = new int[count];
        int jige = 0;
        int youxiu = 0;
        for (int i = 0; i < score.length; i++) {
            score[i] = in.nextInt();
        }
        for (int i = 0; i < score.length; i++) {
            if (score[i] >= 60)
                jige++;
            if (score[i] >= 85)
                youxiu++;
        }
        int jigelv = (int) Math.round((double) jige/(double) count * 100);
        int youxiulv = (int) Math.round((double) youxiu/(double) count * 100);
        System.out.println(jigelv + "%");
        System.out.println(youxiulv + "%");
    }
}
