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
    pre_idx = 0;
    indices = new Map();
    /**
     * @param {number[]} preorder
     * @param {number[]} inorder
     * @return {TreeNode}
     */
    buildTree(preorder, inorder) {
         
        inorder.forEach((val, i) => this.indices.set(val, i));
        return this.dfs(preorder,0, inorder.length - 1);

        }
         dfs(preorder,l, r) {
            if (l > r) return null;
            let root_val = preorder[this.pre_idx++];
            let root = new TreeNode(root_val);
            let mid = this.indices.get(root_val);
            root.left = this.dfs(preorder,l, mid - 1);
            root.right = this.dfs(preorder,mid + 1, r);
            return root;
        }

        
    
}
