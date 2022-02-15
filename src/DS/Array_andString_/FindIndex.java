package DS.Array_andString_;

/**
 * @author Obamazzz
 * @version 1.0
 */
//        给你一个整数数组nums ，请计算数组的 中心下标 。
//        数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
//        如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
//        如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
public class FindIndex {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(new Solution02().pivotIndex(nums));
    }
}
//我的解
class Solution01 {
    public int pivotIndex(int[] nums) {
        int sumLeft = 0;
        int sumRight = 0;
        for (int i = 0; i < nums.length; i++) {
            sumLeft = 0;
            sumRight = 0;
            //如果是第一个索引
            if (i == 0) {
                for (int j = 1; j < nums.length; j++) {
                    sumRight += nums[j];
                }
                if (sumLeft == sumRight) {
                    return 0;
                }
            } else {
                //左边之和
                for (int j = 0; j < i; j++) {
                    sumLeft += nums[j];
                }
                //右边之和
                for (int j = i + 1; j < nums.length; j++) {
                    sumRight += nums[j];
                }
                if (sumLeft == sumRight) {
                    return i;
                }
            }
        }
        return -1;
    }
}
//大神的解
class Solution02 {
    public int pivotIndex(int[] nums) {
        int sum=0,flag=0,end=0;
        for(int i=0;i<nums.length;i++){//sum为数组中所有元素的总和
            sum+=nums[i];
        }
        if(sum-nums[0]==0){//如果除了nums[0]以外的和为0，即0为数组的中心索引
            return 0;
        }
        for(int j=0;j<nums.length;j++){//flag为数组中从索引为0的位置到索引为j的位置的所有元素的和
            flag+=nums[j];
            if(j!=0){
                end=flag-nums[j];//end为数组中从索引为0的位置到索引为j-1的位置的所有元素的和,左边之和
            }
            if(end==sum-flag){//数组中索引为j的位置前的所有元素总和,左边等于右边
                //与数组中索引位置为j的位置后的所有元素总和相等
                return j;
            }
        }
        return -1;
    }
}
