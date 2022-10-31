剑指 Offer 27. 二叉树的镜像

剑指offer题解
7天前
0
27
本问题对应的 leetcode 原文链接：剑指 Offer 27. 二叉树的镜像
本题对应打卡问题：【二叉树专题】剑指 Offer 27. 二叉树的镜像

问题描述
请完成一个函数，输入一个二叉树，该函数输出它的镜像。

例如输入：

     4
/   \
2     7
/ \   / \
1   3 6   9
镜像输出：

     4
/   \
7     2
/ \   / \
9   6 3   1
返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。

示例 1：

输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]
Java
限制：

0 <= 节点个数 <= 1000


解题思路：
递归解析：
终止条件： 当节点 rootroot 为空时（即越过叶节点），则返回 nullnull ；
递推工作：
初始化节点 tmptmp ，用于暂存 rootroot 的左子节点；
开启递归 右子节点 mirrorTree(root.right)mirrorTree(root.right) ，并将返回值作为 rootroot 的 左子节点 。
开启递归 左子节点 mirrorTree(tmp)mirrorTree(tmp) ，并将返回值作为 rootroot 的 右子节点 。
返回值： 返回当前节点 rootroot ；


```
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }
}
```