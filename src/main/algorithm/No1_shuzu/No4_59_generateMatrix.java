/**
 * @program: a-rookie-is-a-god
 * @description: 螺旋矩阵
 * @author: qiaoqiao
 * @create: 2022-02-02 14:10
 **/

// 题目链接：https://leetcode-cn.com/problems/spiral-matrix-ii/
// 给定一个正整数n，生成一个包含 1 到n^2所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
// [螺旋矩阵](https://img-blog.csdnimg.cn/2020121623550681.png)
//    示例:
//
//            输入: 3
//            输出:
//            [
//            [ 1, 2, 3 ],
//            [ 8, 9, 4 ],
//            [ 7, 6, 5 ]
//            ]
public class No2_27_removeNum {
    // 第一种暴力解法：两个for循环，然后不断的寻找符合条件的子序列。
    // 很明显暴力解法的时间复杂度是O(n^2)
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        // 循环次数
        int loop = n / 2;

        // 定义每次循环起始位置
        int startX = 0;
        int startY = 0;

        // 定义偏移量
        int offset = 1;

        // 定义填充数字
        int count = 1;

        // 定义中间位置
        int mid = n / 2;
        while (loop > 0) {
            int i = startX;
            int j = startY;

            // 模拟上侧从左到右
            for (; j<startY + n -offset; ++j) {
                res[startX][j] = count++;
            }

            // 模拟右侧从上到下
            for (; i<startX + n -offset; ++i) {
                res[i][j] = count++;
            }

            // 模拟下侧从右到左
            for (; j > startY; j--) {
                res[i][j] = count++;
            }

            // 模拟左侧从下到上
            for (; i > startX; i--) {
                res[i][j] = count++;
            }

            loop--;

            startX += 1;
            startY += 1;

            offset += 2;
        }

        if (n % 2 == 1) {
            res[mid][mid] = count;
        }

        return res;
    }
}
