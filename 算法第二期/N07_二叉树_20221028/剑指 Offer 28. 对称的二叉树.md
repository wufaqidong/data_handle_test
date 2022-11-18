剑指 Offer 28. 对称的二叉树

剑指offer题解
7天前
0
26
本问题对应的 leetcode 原文链接：剑指 Offer 28. 对称的二叉树
本题对应打卡问题：【二叉树专题】剑指 Offer 28. 对称的二叉树

问题描述
请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
/ \
2   2
/ \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
/ \
2   2
\   \
3    3
返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。

示例 1：

输入：root = [1,2,2,3,4,4,3]
输出：true
Java
示例 2：

输入：root = [1,2,2,null,3,null,3]
输出：false
Java
限制：

0 <= 节点个数 <= 1000


思路：从顶至底递归，判断每对节点是否对称，从而判断树是否为对称二叉树
```
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }
    boolean recur(TreeNode L, TreeNode R) {
        if(L == null && R == null) return true;
        if(L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}
```