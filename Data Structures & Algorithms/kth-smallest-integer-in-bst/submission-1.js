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
     k;
     result;
    /**
     * @param {TreeNode} root
     * @param {number} k
     * @return {number}
     */
        kthSmallest(root, k) { 
         this.k=k;
         this.result=-1;
         this.dfs(root);
         return this.result;
         }
        dfs( root){
        if(!root)return;
        if (this.k===0){
            return;
        }
        this.dfs(root.left);
        this.k--;
        if(this.k===0){
        this.result=root.val;
        }
        this.dfs(root.right);
    }
}
