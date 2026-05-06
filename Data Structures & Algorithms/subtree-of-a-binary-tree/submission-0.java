/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot==null) return true;
        if(root==null) return false;
        if (isSameTree(root,subRoot)) return true;
        return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
    }
      public boolean isSameTree(TreeNode p, TreeNode q) {
       Queue<TreeNode> P=new LinkedList<>();
       Queue<TreeNode> Q=new LinkedList<>();
       P.add(p);
       Q.add(q);
       while(!P.isEmpty()&&!Q.isEmpty()){
        for(int i=P.size();i>0;i--){
            TreeNode node1=P.poll();
            TreeNode node2=Q.poll();
            if(node1==null&&node2==null) continue;
            if(node1==null||node2==null||node1.val!=node2.val) return false;
            P.add(node1.left);
            P.add(node1.right);
            Q.add(node2.left);
            Q.add(node2.right);
        }
    
       }
       return true;
        
    }
}
