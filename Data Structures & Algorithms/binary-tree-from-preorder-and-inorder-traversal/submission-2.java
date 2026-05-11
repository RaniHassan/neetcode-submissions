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
    int root_indx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>();
       for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return dfs(preorder,0,inorder.length-1,map);
        
    }
    public TreeNode dfs(int[] preorder,int l ,int r,Map<Integer,Integer> map){
        if(l>r) return null;
        int root_val=preorder[root_indx++];
        TreeNode root=new TreeNode(root_val);
        int mid=map.get(root_val);
        root.left=dfs(preorder,l,mid-1,map);
        root.right=dfs(preorder,mid+1,r,map);
        return root;

    }
}
