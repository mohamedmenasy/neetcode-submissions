/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
//O(n)
class Solution {
    var maxPathSum = Int.MIN_VALUE
    fun maxPathSum(root: TreeNode?): Int {
        dfs(root)
        return maxPathSum
    }

    fun dfs(node: TreeNode?) : Int {
        if(node == null) return 0
        val leftGain = maxOf(0, dfs(node.left))
        val rightGain = maxOf(0, dfs(node.right))

        val pathThroughNode = node.`val` + leftGain + rightGain
        maxPathSum = maxOf(maxPathSum, pathThroughNode)
        return node.`val` + maxOf(leftGain + rightGain)
    }
}
