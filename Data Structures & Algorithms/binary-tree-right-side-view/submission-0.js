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
     * @return {number[]}
     */
     res = [];
    rightSideView(root) {
        this.res=[];
        this.dfs(root, 0);
        return this.res;
    }
    dfs(node, depth) {
            if (!node) return;

            if (this.res.length === depth) {
                this.res.push(node.val);
            }

            this.dfs(node.right, depth + 1);
            this.dfs(node.left, depth + 1);
        }
}