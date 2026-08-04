class WordDictionary {
    private class TrieNode {
        val children = mutableMapOf<Char, TrieNode>()
        var isEndOfWord = false
    }

    private val root = TrieNode()

    fun addWord(word: String) {
        var current = root

        for(char in word) {
            current = current.children.getOrPut(char) {
                TrieNode()
            }
        }
        current.isEndOfWord = true
    }

    fun search(word: String): Boolean {
        fun dfs(index: Int, node: TrieNode) : Boolean {
            if(index == word.length){
                return node.isEndOfWord
            }
            val char = word[index]
            if(char != '.'){
                val nextNode = node.children[char] ?: return false
                return dfs(index + 1, nextNode)
            }
            for(child in node.children.values){
                if(dfs(index + 1, child)){
                    return true
                }
            }
            return false
        }
        return dfs(0, root)
    }
}
