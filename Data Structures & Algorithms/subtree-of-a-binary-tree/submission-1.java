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
        String s1 = serialize(root);
        String s2 = serialize(subRoot);
        return s1.contains(s2);
    }
    public String serialize(TreeNode node){
        if(node==null) return"null";
        return "#" +node.val+ serialize(node.left)+serialize(node.right);
    }
     
}
