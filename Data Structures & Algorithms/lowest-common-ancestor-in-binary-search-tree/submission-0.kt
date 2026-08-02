/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        val current = root ?: null

        if(p!!.`val` < current!!.`val` && q!!.`val` < current!!.`val`){
            return lowestCommonAncestor(current!!.left, p, q)
        } else if(p!!.`val` > current!!.`val` && q!!.`val` > current!!.`val`){
            return lowestCommonAncestor(current!!.right, p, q)
        }
        return current
    }
}
