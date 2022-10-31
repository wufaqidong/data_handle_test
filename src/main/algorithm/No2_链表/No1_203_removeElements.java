/**
 * @program: a-rookie-is-a-god
 * @description: 移除链表元素
 * @author: qiaoqiao
 * @create: 2022-05-26 22:12
 **/

// 题目链接：https://leetcode-cn.com/problems/remove-linked-list-elements/
// 删除链表中等于给定值 val 的所有节点。
//示例 1：
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
//
//示例 2：
//输入：head = [], val = 1
//输出：[]
//
//示例 3：
//输入：head = [7,7,7,7], val = 7
//输出：[]

// 这里就涉及如下链表操作的两种方式：
// 方法一：直接使用原来的链表来进行删除操作。
// 方法二：设置一个虚拟头结点在进行删除操作。
public ListNode removeElements(ListNode head,int val){
        if(head==null){
        return head;
        }
        // 因为删除可能涉及到头节点，所以设置dummy节点，统一操作
        ListNode dummy=new ListNode(-1,head);
        ListNode pre=dummy;
        ListNode cur=head;
        while(cur!=null){
        if(cur.val==val){
        pre.next=cur.next;
        }else{
        pre=cur;
        }
        cur=cur.next;
        }
        return dummy.next;
        }
/**
 * 不添加虚拟节点方式
 * 时间复杂度 O(n)
 * 空间复杂度 O(1)
 *
 * @param head
 * @param val
 * @return
 */
public ListNode removeElements(ListNode head,int val){
        while(head!=null&&head.val==val){
        head=head.next;
        }
        // 已经为null，提前退出
        if(head==null){
        return head;
        }
        // 已确定当前head.val != val
        ListNode pre=head;
        ListNode cur=head.next;
        while(cur!=null){
        if(cur.val==val){
        pre.next=cur.next;
        }else{
        pre=cur;
        }
        cur=cur.next;
        }
        return head;
        }
