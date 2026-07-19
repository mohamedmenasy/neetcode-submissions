class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        val stack = ArrayDeque<Int>()
        var maxArea = 0

        for(i in heights.indices){
            while(stack.isNotEmpty() && heights[i] < heights[stack.last()]){
                val heightIndex = stack.removeLast()
                val rectangleHeight = heights[heightIndex]
                val width = if(stack.isEmpty()){
                    i
                } else {
                    i - stack.last() - 1
                }
                maxArea = maxOf(maxArea, rectangleHeight * width)
            }
            stack.addLast(i)
        }
        while(stack.isNotEmpty()){
            val heightIndex = stack.removeLast()
            val rectangleHeight = heights[heightIndex]
            val width = if(stack.isEmpty()){
                heights.size
            } else {
                heights.size - stack.last() -1
            }
                maxArea = maxOf(maxArea, rectangleHeight * width)
            }
        return maxArea
    }
}
