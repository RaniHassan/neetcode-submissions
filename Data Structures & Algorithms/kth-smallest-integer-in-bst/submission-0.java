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
    int result,k;
    public int kthSmallest(TreeNode root, int k) {
        this.k=k;
         dfs(root);
         return result;
    }
    public void dfs(TreeNode root){
        if(root==null)return;
        if (k==0){
            return;
        }
        dfs(root.left);
        k--;
        if(k==0){
        result=root.val;
        }
        dfs(root.right);
    }
}
