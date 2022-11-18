剑指 Offer 09. 用两个栈实现队列

剑指offer题解

本问题对应的 leetcode 原文链接：剑指 Offer 09. 用两个栈实现队列
本问题对应打开链接：【基本数据结构】剑指 Offer 09. 用两个栈实现队列

问题描述
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

示例 1：

输入：
["CQueue","appendTail","deleteHead","deleteHead","deleteHead"]
[[],[3],[],[],[]]
输出：[null,null,3,-1,-1]
Java
示例 2:

输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]
Java
限制：

1 <= values <= 10000
最多会对appendTail、deleteHead进行10000 次调用


解题思路：
栈无法实现队列功能： 栈底元素（对应队首元素）无法直接删除，需要将上方所有元素出栈。
双栈可实现列表倒序： 设有含三个元素的栈 A = [1,2,3]A=[1,2,3] 和空栈 B = []B=[]。若循环执行 AA 元素出栈并添加入栈 BB ，直到栈 AA 为空，则 A = []A=[] , B = [3,2,1]B=[3,2,1] ，即 栈 BB 元素实现栈 AA 元素倒序 。
利用栈 BB 删除队首元素： 倒序后，BB 执行出栈则相当于删除了 AA 的栈底元素，即对应队首元素。

```
class CQueue {

    LinkedList<Integer> A, B;
    public CQueue() {
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }
    
    public void appendTail(int value) {
        A.addLast(value);
    }
    
    public int deleteHead() {
        if(!B.isEmpty()) return B.removeLast();
        if(A.isEmpty()) return -1;
        while(!A.isEmpty())
            B.addLast(A.removeLast());
        return B.removeLast();
    }
}
```