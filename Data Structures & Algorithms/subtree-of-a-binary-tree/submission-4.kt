/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

//O(n * m)
class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if(root == null) return false
        if(subRoot == null) return false 

        if(isSameTree(root, subRoot)){
            return true
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }

    fun isSameTree(first: TreeNode?, second: TreeNode?): Boolean {
        if(first == null && second == null) return true
        if(first == null || second == null) return false
        if(first.`val` != second.`val`) return false

        return isSameTree(first.left, second.left) && isSameTree(first.right, second.right)
    }
}
