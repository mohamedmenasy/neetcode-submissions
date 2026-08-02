/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        // base case 
        if(root == null){
            return null
        }

        val invertedLeft = invertTree(root.left)
        val invertedRight = invertTree(root.right)

        root.right = invertedLeft
        root.left = invertedRight

        return root
    }
}
