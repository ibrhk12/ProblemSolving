import java.util.ArrayDeque;
import java.util.Deque;

public class SameTreeBFS2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        deque.addLast(p);
        deque.addLast(q);
        while(!deque.isEmpty()){
            TreeNode node1 = deque.remove();
            TreeNode node2 = deque.remove();
            if(node1.val != node2.val) return false;
            if(node1.left != null && node2.left != null) {
                deque.addLast(node1.left);
                deque.addLast(node2.left);
            }
            else if(node1.left == null && node2.left == null)
                ;
            else
                return false;
            if(node1.right != null && node2.right != null){
                deque.addLast(node1.right);
                deque.addLast(node2.right);
            }
            else if(node1.right == null && node2.right == null)
                ;
            else
                return false;
        }
        return true;
    }
}
