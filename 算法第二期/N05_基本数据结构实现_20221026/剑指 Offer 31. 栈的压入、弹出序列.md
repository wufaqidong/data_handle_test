剑指 Offer 31. 栈的压入、弹出序列

剑指offer题解

本问题对应的 leetcode 原文链接：剑指 Offer 31. 栈的压入、弹出序列
本问题对应打卡链接：【基础数据结构】剑指 Offer 31. 栈的压入、弹出序列

问题描述
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。

示例1 ：

输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
输出：true
解释：我们可以按以下顺序执行：
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
Java
示例2 ：

输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
输出：false
解释：1 不能在 2 之前弹出。
Java
限制：

0 <= pushed.length == popped.length <= 1000
0 <= pushed[i], popped[i] < 1000
pushed 是 popped 的排列。
解题思路
视频讲解直达： 本题视频讲解


算法流程：
初始化： 辅助栈 stackstack ，弹出序列的索引 ii ；
遍历压栈序列： 各元素记为 numnum ；
元素 numnum 入栈；
循环出栈：若 stackstack 的栈顶元素 == 弹出序列元素 popped[i]popped[i] ，则执行出栈与 i++i++ ；
返回值： 若 stackstack 为空，则此弹出序列合法。


```
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
```