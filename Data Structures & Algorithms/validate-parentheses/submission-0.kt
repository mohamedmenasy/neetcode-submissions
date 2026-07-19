class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()

        for(char in s){
            if(char == '(' || char =='[' || char == '{'){
                stack.addLast(char)
            } else {
                if(stack.isEmpty()) return false
                val open = stack.removeLast()
                if(char == ')' && open != '(' ||
                char == ']' && open != '[' ||
                char == '}' && open != '{' 
                ){
                    return false
                }
            }
        }
        return stack.isEmpty()

    }
}
