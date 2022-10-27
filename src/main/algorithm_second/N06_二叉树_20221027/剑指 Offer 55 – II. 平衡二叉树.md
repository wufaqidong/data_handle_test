剑指 Offer 55 – II. 平衡二叉树

剑指offer题解
3天前
0
7
本问题对应的 leetcode 原文链接：剑指 Offer 55 – II. 平衡二叉树
本问题配套打卡直达：【二叉树专题】剑指 Offer 55 – II. 平衡二叉树

问题描述
输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

示例 1:

给定二叉树 [3,9,20,null,null,15,7]

    3
/ \
9  20
/  \
15   7
Java
返回 true 。

示例 2:

给定二叉树 [1,2,2,3,3,null,null,4,4]

       1
      / \
     2   2
    / \
3   3
/ \
4   4
Java
返回 false 。

限制：

0 <= 树的结点个数 <= 10000


思路：后序遍历 + 剪枝 （从底至顶）
```
class Solution {
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if(left == -1) return -1;
        int right = recur(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
```