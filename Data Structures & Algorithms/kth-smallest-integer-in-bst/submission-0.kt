/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val stack = ArrayDeque<TreeNode>()
        var current = root
        var count = 0
        while(current != null || stack.isNotEmpty()){
            while(current != null){
                stack.addLast(current)
                current = current.left   
            }
            current = stack.removeLast()
            count++
            if(count == k){
                return current!!.`val`
            }
            current = current.right
        }
        return 0
    }
}
