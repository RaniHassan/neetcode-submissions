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
        Map<TreeNode,Integer>map=new HashMap<>();
        map.put(null,0);
        Stack<TreeNode> s=new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode node=s.peek();
            if(node.left!=null&&!map.containsKey(node.left)){
                s.push(node.left);
            }
            if(node.left!=null&&!map.containsKey(node.left)){
                s.push(node.left);
            }
            else if(node.right!=null&&!map.containsKey(node.right)){
                s.push(node.right);
            }
            else{
                node=s.pop();
                int left=map.get(node.left);
                int right=map.get(node.right);
                if(Math.abs(left-right)>1) return false;
                map.put(node,1+Math.max(left,right));
                
            }
        }
        return true;
        
    }
    
}
