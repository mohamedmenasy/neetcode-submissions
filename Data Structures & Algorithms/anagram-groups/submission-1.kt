class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val groups = mutableMapOf<String, MutableList<String>>()
        for(str in strs){
            val key = str.toCharArray().sorted().joinToString("")
            groups.getOrPut(key){ mutableListOf() }.add(str)
        }
        return groups.values.toList()
    }
}
