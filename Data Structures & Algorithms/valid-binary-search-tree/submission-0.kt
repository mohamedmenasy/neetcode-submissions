/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    fun validate(node: TreeNode?, lower: Long, upper: Long): Boolean {
        if(node == null){
            return true
        }
        if(node.`val` <= lower || node.`val` >= upper){
            return false
        }
        return validate(node.left, lower, node.`val`.toLong()) && 
                validate(node.right, node.`val`.toLong(), upper)
    }
}
