class Solution {
    fun minWindow(s: String, t: String): String {
        if(t.length > s.length){
            return ""
        }

        if(s == t){
            return s
        }

        val need = mutableMapOf<Char, Int>()
        val window = mutableMapOf<Char, Int>()
        for(char in t){
                need[char] = need.getOrDefault(char, 0) + 1
        }
        val required = need.size
        var formed = 0
        var left = 0

        var resultStart = 0
        var minLength = Int.MAX_VALUE
            
            for(right in s.indices){
                val current = s[right]
                window[current] = window.getOrDefault(current, 0) + 1
                if(need.containsKey(current) && window[current] == need[current]){
                    formed++
                }

                while (formed == required) {
                    val windowLength = right - left + 1

                    // Update the best result if this window is smaller
                    if (windowLength < minLength) {
                        minLength = windowLength
                        resultStart = left
                    }

                    val leftChar = s[left]
                    window[leftChar] = window.getOrDefault(leftChar, 0) - 1
                    left++

                    if (
                        need.containsKey(leftChar) &&
                        window[leftChar]!! < need[leftChar]!!
                    ) {
                        formed--
                    }
                }
            }
        return if (minLength == Int.MAX_VALUE) {
            ""
        } else {
            s.substring(resultStart, resultStart + minLength)
        }
    }
}

