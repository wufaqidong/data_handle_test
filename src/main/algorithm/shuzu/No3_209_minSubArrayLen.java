/**
 * @program: a-rookie-is-a-god
 * @description: 长度最小的子数组
 * @author: qiaoqiao
 * @create: 2022-02-02 14:10
 **/

// 题目链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum/
// 给定一个含有n个正整数的数组和一个正整数s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。
// 如果不存在符合条件的子数组，返回 0。
public class No2_27_removeNum {
    // 第一种暴力解法：两个for循环，然后不断的寻找符合条件的子序列。
    // 很明显暴力解法的时间复杂度是O(n^2)
    public int min1(int[] nums, int val) {
        int result = INT32_MAX; // 最终的结果
        int sum = 0; // 子序列的数值之和
        int subLength = 0; // 子序列的长度
        for (int i = 0; i < nums.size(); i++) { // 设置子序列起点为i
            sum = 0;
            for (int j = i; j < nums.size(); j++) { // 设置子序列终止位置为j
                sum += nums[j];
                if (sum >= s) { // 一旦发现子序列和超过了s，更新result
                    subLength = j - i + 1; // 取子序列的长度
                    result = result < subLength ? result : subLength;
                    break; // 因为我们是找符合条件最短的子序列，所以一旦符合条件就break
                }
            }
        }
        // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
        return result == INT32_MAX ? 0 : result;
    }

}
