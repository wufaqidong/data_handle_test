/**
 * @program: a-rookie-is-a-god
 * @description: 二分法查找
 * @author: qiaoqiao
 * @create: 2022-02-02 14:10
 **/

// 题目链接：https://leetcode-cn.com/problems/binary-search/
// 二分法前提：1、有序数组；2、无重复数据
public class No1_704_erFenFa {
    // 第一种左闭右闭写法
    public int search1(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        /*
            求数组中间下标最好不要用(left + right) / 2
            int middle = (left + right) / 2; 会因为left+right超过int而溢出，于是提出了如下办法：
            int middle = left + (right - left) / 2; 这样就不会溢出了，等价于：
            int middle = left + (right - left) >>１;

            为什么int middle = left + (right - left) / 2不会溢出？
            因为:left <= right;
                left + （right - left）= right;
            所以:left + (right - left) / 2 <= right;

            关于溢出：
            int x = 1999999998;
            int y = 1999999998;
            int mid = (x+y) / 2;
            int mid2 = x + (y-x) / 2;
            System.out.println(mid); //-147483650
            System.out.println(mid2); //1999999998
        */
        while (left <= right) {
            int mid = left + ((right - left) >> 1);

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    // 第二种左闭右开写法
    public int search2(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + ((right - left) >> 1);

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return -1;
    }
}
