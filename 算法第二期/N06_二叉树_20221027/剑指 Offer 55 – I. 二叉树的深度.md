剑指 Offer 55 – I. 二叉树的深度

剑指offer题解
3天前
0
5
本问题对应的 leetcode 原文链接：剑指 Offer 55 – I. 二叉树的深度
本问题配套打卡直达：【二叉树专题】剑指 Offer 55 – I. 二叉树的深度

问题描述
输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。

例如：

给定二叉树 [3,9,20,null,null,15,7]，

    3
/ \
9  20
/  \
15   7
返回它的最大深度 3 。

提示：

节点总数 <= 10000


解题思路：
树的遍历方式总体分为两类：深度优先搜索（DFS）、广度优先搜索（BFS）；

常见的 DFS ： 先序遍历、中序遍历、后序遍历；
常见的 BFS ： 层序遍历（即按层遍历）

```
class Solution {
    public int maxDepth(TreeNode root) {

        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
```