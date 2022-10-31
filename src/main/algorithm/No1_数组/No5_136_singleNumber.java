
package demo01_data_handle;

/**
 * @ClassName MainTest
 * @Description TODO
 * @Author zxl
 * @Date 2022/5/27 9:21
 * @Version 1.0
 */
public class No5_136_singleNumber.java {

    //给定一个非空整数数组，除了某个元素只出现一次以外，
   // 其余每个元素均出现两次。找出那个只出现了一次的元素。
    public static void main(String[] args) {
        int[] nums = {7,3,3,5,6,5,6};
        System.out.println(singleNumber(nums));
    }

    // 其实我不太懂 与运算
    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
