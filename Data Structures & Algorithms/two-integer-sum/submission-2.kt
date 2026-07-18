class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, Int>()
            nums.forEachIndexed{ index, value ->
            val complement = target - value
            val complementIndex = map[complement]
                if(complementIndex != null){
                    return intArrayOf(complementIndex, index)
                } else {
                    map[value] = index
                }
            }
            return intArrayOf()
    }
}
