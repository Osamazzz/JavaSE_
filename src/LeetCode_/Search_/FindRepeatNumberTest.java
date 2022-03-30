package LeetCode_.Search_;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Obamazzz
 * @version 1.0
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
public class FindRepeatNumberTest {
    public int findRepeatNumber(int[] nums) {
        Set<String> set = new HashSet<>();
        boolean flag = true;
        String str = null;
        for (int num : nums) {
            str = String.valueOf(num);
            flag = set.add(str);
            //如果添加失败，则说明有重复
            if (!flag) {
                return num;
            }
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        Set<Integer> dic = new HashSet<>();
        for(int num : nums) {
            if(dic.contains(num)) return num;
            dic.add(num);
        }
        return -1;
    }
}
