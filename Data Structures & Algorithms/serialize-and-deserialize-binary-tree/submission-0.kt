/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec {
    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String {
        val result = StringBuilder()
        
        fun dfs(node: TreeNode?){
            if(node == null){
                result.append("N,")
                return
            }
            result.append(node.`val`).append(",")
            dfs(node.left)
            dfs(node.right)
        }
        dfs(root)
        return result.toString()
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        val values = data.split(",")
        var index = 0

        fun dfs():TreeNode?{
            val value = values[index]
            index++

            if(value == "N"){
                return null
            }

            val node = TreeNode(value.toInt())

            node.left = dfs()
            node.right = dfs()

            return node
        }

        return dfs()
    }
}
