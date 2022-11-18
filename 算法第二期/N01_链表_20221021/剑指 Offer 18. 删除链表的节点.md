剑指 Offer 18. 删除链表的节点
难度：★

要求掌握程度：★★★★★

说明：基础题，0 技巧，属于基本功了，自己先试着写一写，如果不会的 ，建议多画个图，多写几遍。

注意点：删除头节点 + 空节点

问题的描述及其答案+代码实现看这里：https://www.playoffer.cn/440.html

问题描述
给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

返回删除后的链表的头节点。

注意：此题对比原题有改动

示例 1:
输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
示例 2:

输入: head = [4,5,1,9], val = 1
输出: [4,5,9]
解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
说明：

题目保证链表中节点的值互不相同
若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点

```
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        // 如果头节点为null，直接返回
        if(head == null){
            return null;
        }
        // 如果头节点就是要删除的节点，则返回头节点的下一个节点
        if (head.val == val) {
            return head.next;
        }
        // 双指针，初始化
        ListNode pre = head, cur = head.next;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) {
            pre.next = cur.next;
        }
        return head;
    }
}
```