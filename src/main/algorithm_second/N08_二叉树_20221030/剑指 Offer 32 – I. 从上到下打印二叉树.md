剑指 Offer 32 – I. 从上到下打印二叉树

剑指offer题解
1周前
0
14
本问题对应的 leetcode 原文链接：剑指 Offer 32 – I. 从上到下打印二叉树
本次对应打卡任务：【二叉树专题】剑指 Offer 32 – I. 从上到下打印二叉树

问题描述
从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
/ \
9  20
/  \
15   7
返回：

[3,9,20,15,7]
提示：

节点总数 <= 1000


解题思路：
借助 队列 的先入先出特性来实现


```
class Solution {
    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>(){{ add(root); }};
        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }
}
```