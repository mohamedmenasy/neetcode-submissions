class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val frequency = mutableMapOf<Int, Int>()
        for(num in nums){
            frequency[num] = frequency.getOrDefault(num, 0) + 1
        }
        return frequency.entries.sortedByDescending {it.value}.take(k).map{it.key}.toIntArray()
    }
}
