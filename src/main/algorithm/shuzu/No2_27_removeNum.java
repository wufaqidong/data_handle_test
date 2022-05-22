/**
 * @program: a-rookie-is-a-god
 * @description: 移除元素
 * @author: qiaoqiao
 * @create: 2022-02-02 14:10
 **/

// 题目链接：https://leetcode-cn.com/problems/remove-element/
// 给你一个数组nums和一个值val，你需要原地移除所有数值等于val的元素，并返回移除后数组的新长度。
// 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并**原地**修改输入数组。
// 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
public class No2_27_removeNum {
    // 第一种暴力解法：两层for循环，一个for循环遍历数组元素 ，第二个for循环更新数组。
    // 很明显暴力解法的时间复杂度是O(n^2)
    public int remove1(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == val) { // 发现需要移除的元素，就将数组集体向前移动一位
                for (int j = i + 1; j < size; j++) {
                    nums[j - 1] = nums[j];
                }
                i--; // 因为下标i以后的数值都向前移动了一位，所以i也向前移动一位
                size--; // 此时数组的大小-1
            }
        }
        return size;
    }


    // 第二种双指针（快慢指针）写法：通过一个快指针和慢指针在一个for循环下完成两个for循环的工作。
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public int remove2(int[] nums, int val) {
        // 快慢指针
        int fastIndex = 0;
        int slowIndex;
        for (slowIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }

    // 总结：很多考察数组和链表操作的题都可以使用双指针法解决
}
