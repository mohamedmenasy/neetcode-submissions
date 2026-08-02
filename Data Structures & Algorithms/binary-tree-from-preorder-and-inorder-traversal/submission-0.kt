/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val inorderIndex = mutableMapOf<Int, Int>()

        for(i in inorder.indices){
            inorderIndex[inorder[i]] = i
        }

        var preorderIndex = 0


        fun build(left: Int, right: Int): TreeNode? {
            if(left > right ) return null
            val rootValue = preorder[preorderIndex]
            preorderIndex++

            val root = TreeNode(rootValue)
            val middle = inorderIndex[rootValue]!!

            root.left = build(left, middle - 1)
            root.right = build(middle + 1, right)

            return root
        }

        return build(0, inorder.lastIndex)
    }
}
