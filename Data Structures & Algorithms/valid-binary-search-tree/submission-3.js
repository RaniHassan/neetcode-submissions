/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     constructor(val = 0, left = null, right = null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    /**
     * @param {TreeNode} root
     * @return {boolean}
     */
    isValidBST(root) {
          let q=new Queue();
        if(!root)return true;
        q.push([root,-Infinity,Infinity]);
        while(!q.isEmpty()){
             const [node,min,max]=q.pop();
            if(!(node.val>min&&node.val<max))return false;
            if(node.left!=null){
            q.push([node.left,min,node.val]);
            }
            if(node.right!=null){
            q.push([node.right,node.val,max]);
            }
        }
        return true;
    }
    
}
