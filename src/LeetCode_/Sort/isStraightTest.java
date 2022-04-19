package LeetCode_.Sort;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Obamazzz
 * @version 1.0
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 */
public class isStraightTest {
    public boolean isStraight(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Set<Integer> repeat = new HashSet<>();
        for (int i : nums) {
            if (i == 0) continue;//遇到大小王跳过
            max=Math.max(max,i);
            min=Math.min(min,i);
            if (!repeat.add(i)) {
                return false;//如果有重复就提前返回false
            }
        }
        return max - min < 5;
    }
    public boolean isStraight2(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for(int num : nums) {
            if(num == 0) continue; // 跳过大小王
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            if(repeat.contains(num)) return false; // 若有重复，提前返回 false
            repeat.add(num); // 添加此牌至 Set
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }
}
