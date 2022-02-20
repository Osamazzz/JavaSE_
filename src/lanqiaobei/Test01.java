package lanqiaobei;

import java.util.Scanner;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class Test01 {
    public static void main(String[] args) {
        //暴力解法
        int countTwo = 0;
        for (int i = 1; i <= 2020; i++) {
            if (i == 2) {
                countTwo++;
            } else if (i >=10 && i < 100) {
                int shi = i / 10;
                int ge = i % 10;
                if (ge == 2)
                    countTwo++;
                if (shi == 2)
                    countTwo++;
            } else if (i >= 100 && i < 1000) {
                int shi = (i / 10) % 10;
                int ge = i % 10;
                int bai = i / 100;
                if (ge == 2)
                    countTwo++;
                if (shi == 2)
                    countTwo++;
                if (bai == 2)
                    countTwo++;
            } else {
                int qian = i / 1000;
                int bai = (i - 1000 * qian) / 100 ;
                int shi = (i / 10) % 10;
                int ge = i % 10;
                if (ge == 2)
                    countTwo++;
                if (shi == 2)
                    countTwo++;
                if (bai == 2)
                    countTwo++;
                if (qian == 2)
                    countTwo++;
            }
        }
        System.out.println(countTwo);

    }
}
