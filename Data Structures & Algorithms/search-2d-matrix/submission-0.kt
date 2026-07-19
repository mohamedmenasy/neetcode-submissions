class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val rows = matrix.size
        val cols = matrix[0].size

        var left = 0
        var right = rows * cols - 1

        while(left <= right){
            var mid = left + (right - left) / 2
            val row = mid / cols
            val col = mid % cols
            val value = matrix[row][col]

            when{
                value < target -> left = mid + 1
                value > target -> right = mid - 1
                else -> return true
            }
        }
        return false
    }
}
