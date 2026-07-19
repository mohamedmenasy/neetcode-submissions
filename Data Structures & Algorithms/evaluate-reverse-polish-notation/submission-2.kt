class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()

        for(token in tokens){
            val number = token.toIntOrNull()
            if(number != null){
                stack.addLast(number)
            } else {
                val right = stack.removeLast()
                val left = stack.removeLast()
                val result = when(token){
                    "+" -> left + right
                    "-" -> left - right
                    "*" -> left * right
                    "/" -> left / right
                    else -> 0
                }
                stack.addLast(result)
            }
        }
        return stack.last()
    }
}
