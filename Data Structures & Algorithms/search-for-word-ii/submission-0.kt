class Solution {
    private class TrieNode {
        val children = mutableMapOf<Char, TrieNode>()
        var word: String? = null
    }

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val root = TrieNode()
        val result = mutableListOf<String>()

        for(word in words){
            var current = root
            for(char in word){
                current = current.children.getOrPut(char) {
                    TrieNode()
                }
            }
            current.word = word
        }

        val directions = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1)
        )

        fun dfs(row: Int, col: Int, node: TrieNode) {
            val char = board[row][col]
            val nextNode = node.children[char] ?: return

            nextNode.word?.let { foundWord ->
                result.add(foundWord)
                nextNode.word = null
            }

            board[row][col] = '#'

            for (direction in directions) {
                val newRow = row + direction[0]
                val newCol = col + direction[1]

                if (
                    newRow in board.indices &&
                    newCol in board[0].indices &&
                    board[newRow][newCol] != '#'
                ) {
                    dfs(newRow, newCol, nextNode)
                }
            }

            board[row][col] = char
        }

        for (row in board.indices) {
            for (col in board[0].indices) {
                dfs(row, col, root)
            }
        }

        return result
    }
}
