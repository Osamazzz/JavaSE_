package January;

import java.util.Arrays;

public class recursionTest {
    public static void main(String[] args) {
        Tower tower = new Tower();
        tower.move(4,'a', 'b', 'c');

    }
}

class Solution {
    public int solve(int day) {
        if (day == 10) {
            return 1;
        }else if (day >= 1 && day <= 9) {
            return (solve(day + 1) + 1) * 2;
        } else {
            return -1;
        }
    }
}

class Tower {
    public void move(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println(a + "->" + c);
        } else {
            move(num - 1, a, c, b);
            System.out.println(a + "->" + c);
            move(num - 1, b, a, c);
        }
    }
}