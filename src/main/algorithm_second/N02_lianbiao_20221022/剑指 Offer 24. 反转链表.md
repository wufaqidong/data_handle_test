剑指 Offer 24. 反转链表

剑指offer题解

本问题对应的 leetcode 原文链接：剑指 Offer 24. 反转链表

问题描述
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL

```
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode cur = head, pre = null;

        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;

        // 额外空间复杂度=1
    }
}
方法二
class Solution {
    public ListNode reverseList(ListNode head) {
/*
        我们需要考虑F(n)和F(n-1)的关系，如果n代表以node为头节点的单向链表
        那么n-1就代表以node.next为头节点的单向链表
        令F(node.next)为问题：反转以node.next为头节点的单向链表
        那么，F(node)和F(node.next)之间的关系是?
        1 -> 2 -> 3
        那么，F(node=1)=F(node=2)+?
        这里假设子问题F(node=2)已经解决，那么我们如何解决F(node=1)：
        很明显，我们需要反转node=2和node=1， 即 node.next.next=node; 同时 node.next=null;
        所以，这个问题就可以是：F(node=1)=F(node=2)+ 反转node=2和node=1
        */
        // 递归出口:0或1个节点反转了就是本身
        if(head == null || head.next == null) {
            return head;
        }
        /*
        假设主函数实现的黑盒功能是:
        反转以head为头结点的链表,并让尾结点指空,同时返回反转后链表的头结点
        */
        // 反转head.next为头结点的链表并且让head.next.next指空,并返回head.next反转后的新的头结点
        ListNode res = reverseList(head.next);
        // 此时假设已经完成了head.next之后的反转:1->2<-3
        // 只需再将2->1即可完成反转,这个就是完成2->1的过程
        // 第一次执行head必定为1
        head.next.next = head;
        // 1指空的过程
        head.next = null;
        // 返回反转以head为偷的链表的头结点,其实也反转head.next的一样
        return res;
    }
}
```