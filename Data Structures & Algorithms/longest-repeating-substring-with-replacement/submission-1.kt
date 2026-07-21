class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var left = 0
        var longest = 0
        var maxFrequency = 0
        val frequency = IntArray(26)

        for(right in s.indices){
            val index = s[right] - 'A'
            frequency[index]++
            maxFrequency = maxOf(maxFrequency, frequency[index])

            while((right - left + 1) - maxFrequency > k){
                val leftIndex = s[left] - 'A'
                frequency[leftIndex]--
                left++
            }
            longest = maxOf(longest, right - left + 1)
        }
        return longest
    }
}
