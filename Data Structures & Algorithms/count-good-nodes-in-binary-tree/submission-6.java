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
    public int goodNodes(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();
        if(root==null)return 0;
       
        int count=0;
        q.offer(new Pair(root,root.val));
        while(!q.isEmpty()){
            Pair p=q.poll();
            int max=p.maxVal;
            TreeNode node=p.node;
            if(node.val>=p.maxVal){
                max=node.val;
                count++;
            }
            if(node.left!=null){
                q.offer(new Pair(node.left,max));
            }
            if(node.right!=null){
             q.offer(new Pair(node.right,max));
            }
        }
        return count;
        
    }
    
    class Pair{
        private TreeNode node;
        private int maxVal;
        public Pair(TreeNode node,int maxVal){
            this.node=node;
            this.maxVal=maxVal;
        }
    }
}
