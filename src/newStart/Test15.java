package newStart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Test15 {
    public static void main(String[] args) {

    }

    public boolean findSubarrays(int[] nums) {
        HashSet<Integer> dic = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            if (dic.contains(sum)) return true;
            dic.add(sum);
        }
        return false;
    }
}
