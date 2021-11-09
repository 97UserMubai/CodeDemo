package leetcode.easy;
//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
// 你可以按任意顺序返回答案。
// 示例 1：
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 示例 2：
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 示例 3：
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 提示：
// 2 <= nums.length <= 10⁴
// -10⁹ <= nums[i] <= 10⁹
// -10⁹ <= target <= 10⁹
// 只会存在一个有效答案
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？

import java.util.HashMap;

public class TwoNums {
    public static int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];

        /*
         * 通过 target - index[i] -> 得到差值->i的映射
         * 继续遍历，当得到index[1]已经存在该结果时，进行结果加工并返回
         */
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                indexs[0] = hash.get(nums[i]);
                indexs[1] = i;
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target - nums[i], i);
        }
        // // 双重循环 循环极限为(n^2-n)/2
        // for(int i = 0; i < nums.length; i++){
        //     for(int j = nums.length - 1; j > i; j --){
        //         if(nums[i]+nums[j] == target){
        //            indexs[0] = i;
        //            indexs[1] = j;
        //            return indexs;
        //         }
        //     }
        // }
        return indexs;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] result = twoSum(nums, 4);
        System.out.println("debug");
    }
    //再进阶，当需求变成了多个数字相加？
}
