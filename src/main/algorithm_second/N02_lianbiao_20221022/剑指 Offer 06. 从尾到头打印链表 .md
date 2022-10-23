剑指 Offer 06. 从尾到头打印链表

剑指offer题解

本问题对应的 leetcode 原文链接：剑指 Offer 06. 从尾到头打印链表

问题描述
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
示例 1：

输入：head = [1,3,2]
输出：[2,3,1]
限制：

0 <= 链表长度 <= 10000

```
class Solution {
    // 从右边=往左填充
    public int[] reversePrint(ListNode head) {
        if(head == null)
            return new int[0];
        // 统计链表节点个数，方便创建数组
        int count = 0;
        ListNode temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        int[] res = new int[count];
        int k = count - 1;
        // 从由往左填充数组
        while(head != null){
            res[k--] = head.val;
            head = head.next;
        }

        return res;
    }
}
```