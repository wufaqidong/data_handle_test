
package demo01_data_handle;

/**
 * @ClassName MainTest
 * @Description TODO
 * @Author zxl
 * @Date 2022/5/27 9:21
 * @Version 1.0
 */
public class No6_169_majorityElement {

    //给定一个大小为 n 的数组，找到其中的多数元素。
    // 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
    public static void main(String[] args) {
        int[] nums = {7,3,3,5,6,5,6};
        System.out.println(majorityElement(nums));
    }

    // 数组中出现次数 大于 ⌊ n/2 ⌋ 的元素 排序之后中间数
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length/2;
        return nums[mid];
    }
}
