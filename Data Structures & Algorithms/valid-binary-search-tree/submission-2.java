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
    public class Node{
        private TreeNode node;
        private int min;
        private int max;
        public Node(TreeNode node,int min,int max){
            this.node=node;
            this.min=min;
            this.max=max;
        }
    }
    public boolean isValidBST(TreeNode root) {
        Queue<Node> q=new LinkedList<>();
        if(root==null)return true;
        q.offer(new Node(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
        while(!q.isEmpty()){
            Node cur=q.poll();
            TreeNode node=cur.node;
            if(!(node.val>cur.min&&node.val<cur.max))return false;
            if(node.left!=null){
            q.offer(new Node(node.left,cur.min,node.val));
            }
            if(node.right!=null){
            q.offer(new Node(node.right,node.val,cur.max));
            }
        }
        return true;
    }
    
}
