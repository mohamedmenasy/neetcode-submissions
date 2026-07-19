class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size)
        val stack = ArrayDeque<Int>()

        for(currentIndex in temperatures.indices){
            while(stack.isNotEmpty() && temperatures[currentIndex] > temperatures[stack.last()]){
                val previousIndex = stack.removeLast()
                result[previousIndex] = currentIndex - previousIndex
            }
            stack.addLast(currentIndex)
        }
        return result
    }
}
