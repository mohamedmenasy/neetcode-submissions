class Solution {

    fun encode(strs: List<String>): String {
        val encoded = StringBuilder()

        for(word in strs){
            encoded.append(word.length)
            encoded.append('#')
            encoded.append(word)
        }
        return encoded.toString()
    }

    fun decode(str: String): List<String> {
        val result = mutableListOf<String>()
        var i = 0

        while(i < str.length){
            var j = i

            while(str[j] != '#'){
                j++
            }

            val length = str.substring(i, j).toInt()
            val start = j + 1
            val end = start + length

            result.add(str.substring(start, end))
            i = end
        }
        return result
    }
}
