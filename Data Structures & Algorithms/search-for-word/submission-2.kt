class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        fun dfs(row: Int, col: Int, index: Int): Boolean{
            if(index == word.length){
                return true
            }

            if(
                row !in board.indices ||
                col !in board[0].indices ||
                board[row][col] != word[index]
            ) {
                return false
            }

            val original = board[row][col]
            board[row][col] = '#'

            val found = 
                dfs(row + 1, col, index + 1) ||
                dfs(row - 1, col, index + 1) ||
                dfs(row, col + 1, index + 1) ||
                dfs(row, col - 1, index + 1)

            board[row][col] = original
            
            return found
        }

        for(row in board.indices){
            for(col in board[0].indices){
                if(dfs(row, col, 0)){
                    return true
                }
            }
        }

        return false
    }
}
