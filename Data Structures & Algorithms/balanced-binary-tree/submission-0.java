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
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        int r=gethight(root.right);
        int l=gethight(root.left);
        if(Math.abs(r-l)>1)
        return false;
        return isBalanced(root.right)&&isBalanced(root.left);
        
    }
    public int gethight(TreeNode node){
        if(node==null)return 0;
        return 1+Math.max(gethight(node.left),gethight(node.right));
    }
}
