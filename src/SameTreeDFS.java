public class SameTreeDFS {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p.left == null && q.right == null) return true;
        if(p.left == null || q.right == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
    }
}
