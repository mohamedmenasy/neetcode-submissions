class Solution {
    fun maxArea(heights: IntArray): Int {
        var left = 0
        var right = heights.lastIndex
        var maxArea = 0

        while(left < right){
            val width = right - left
            val containerHeight = minOf(heights[left], heights[right])
            val area = containerHeight * width
            maxArea = maxOf(area, maxArea)
            /*
            The shorter bar limits the container’s height. Moving the taller bar inward only reduces the width while keeping the same height limit, so the area cannot improve.
To possibly find a larger area, discard the shorter bar and search for a taller one.
            */
            if(heights[left] < heights[right]){
                left++
            }else{
                right--
            }
        }
        return maxArea
    }
}
