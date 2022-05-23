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


    // 第二种：滑动窗口
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    // 动图：https://code-thinking.cdn.bcebos.com/gifs/209.%E9%95%BF%E5%BA%A6%E6%9C%80%E5%B0%8F%E7%9A%84%E5%AD%90%E6%95%B0%E7%BB%84.gif
    /**
     所谓滑动窗口，**就是不断的调节子序列的起始位置和终止位置，从而得出我们要想的结果**。
     在本题中实现滑动窗口，主要确定如下三点：

     * 窗口内是什么？
     * 如何移动窗口的起始位置？
     * 如何移动窗口的结束位置？

     窗口就是 满足其和 ≥ s 的长度最小的 连续 子数组。
     窗口的起始位置如何移动：如果当前窗口的值大于s了，窗口就要向前移动了（也就是该缩小了）。
     窗口的结束位置如何移动：窗口的结束位置就是遍历数组的指针，窗口的起始位置设置为数组的起始位置就可以了。
     解题的关键在于 窗口的起始位置如何移动，如图所示：

     ![leetcode_209](https://img-blog.csdnimg.cn/20210312160441942.png)

     可以发现**滑动窗口的精妙之处在于根据当前子序列和大小的情况，不断调节子序列的起始位置。从而将O(n^2)暴力解法降为O(n)。
    */
    public int remove2(int[] nums, int val) {
        int result = INT32_MAX;
        int sum = 0; // 滑动窗口数值之和
        int i = 0; // 滑动窗口起始位置
        int subLength = 0; // 滑动窗口的长度
        for (int j = 0; j < nums.size(); j++) {
            sum += nums[j];
            // 注意这里使用while，每次更新 i（起始位置），并不断比较子序列是否符合条件
            while (sum >= s) {
                subLength = (j - i + 1); // 取子序列的长度
                result = result < subLength ? result : subLength;
                sum -= nums[i++]; // 这里体现出滑动窗口的精髓之处，不断变更i（子序列的起始位置）
            }
        }
        // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
        return result == INT32_MAX ? 0 : result;
    }

    // 总结：很多考察数组和链表操作的题都可以使用双指针法解决
}
