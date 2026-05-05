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
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
       Map<TreeNode,int[]> map=new HashMap<>();
       map.put(null,new int[]{0,0});
       Stack<TreeNode> stack=new Stack<>();
       if(root==null)return 0;
       stack.push(root);
       while(!stack.isEmpty()){
        TreeNode node=stack.peek();
        if(node.left!=null&&!map.containsKey(node.left)){
        stack.push(node.left);
       }
       else if(node.right!=null&&!map.containsKey(node.right)){
        stack.push(node.right);
       }
        else {stack.pop();
            int[] leftData=map.get(node.left);
            int[] rightData=map.get(node.right);
            int hight=1+Math.max(leftData[1],rightData[1]);
            int diameter=Math.max(leftData[1]+rightData[1],Math.max(leftData[0],rightData[0]));
            map.put(node,new int[]{diameter,hight});
        }
        

       }
        return map.get(root)[0];

    }
    
}
