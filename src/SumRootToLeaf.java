public class SumRootToLeaf {

     // Definition for a binary tree node.
      public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode() {
         }

         TreeNode(int val) {
             this.val = val;
         }

         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
    int resultSum = 0;
    public void preOrder(TreeNode root, int number){
        if(root != null){
            number = number << 1 | root.val;
            if(root.left == null && root.right == null)
                resultSum += number;
            preOrder(root.left, number);
            preOrder(root.right, number);
        }
    }
    public int sumRootToLeaf(TreeNode root) {
        preOrder(root, 0);
        return resultSum;
    }
}
