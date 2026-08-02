/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        if(root == null) return result

        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        while(queue.isNotEmpty()){
            val levelSize = queue.size
            val level = mutableListOf<Int>()
            repeat(levelSize){
                val node = queue.removeFirst()
                level.add(node.`val`)
                node.left?.let { queue.addLast(it) }
                node.right?.let { queue.addLast(it) }
            }
            result.add(level)
        }

        return result
    }
}
