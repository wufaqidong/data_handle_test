
思路：
1、先序遍历树 A 中的每个节点（n_A），对应函数 isSubStructure(A, B)。
2、判断树 A 中 以节点n_A 为根节点的子树 是否包含树 B ，对应函数 recur(A, B)。
```
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
```