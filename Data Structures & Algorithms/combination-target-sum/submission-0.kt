class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val current = mutableListOf<Int>()

        fun backtrack(start: Int, remaining: Int){
            if(remaining == 0){
                result.add(current.toList())
                return
            }
            if(remaining < 0){
                return
            }

            for(i in start until nums.size){
                current.add(nums[i])
                backtrack(
                    start = i,
                    remaining = remaining - nums[i]
                )
                current.removeAt(current.lastIndex)
            }
        }
        backtrack(0, target)
        return result
    }
}
