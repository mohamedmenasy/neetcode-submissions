class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var left = 0
        var longest = 0
        val characters = mutableSetOf<Char>()

        for(right in s.indices){
            val current = s[right]
            while(characters.contains(current)){
                characters.remove(s[left])
                left++
            }
            characters.add(current)
            longest = maxOf(longest,right - left + 1)
        }
        return longest 
    }
}
