class MedianFinder {
    private val left = PriorityQueue<Int>(compareByDescending { it } ) //max heap
    private val right = PriorityQueue<Int>() // min heap


    fun addNum(num: Int) {
        if(left.isEmpty() || num < left.peek()){
            left.add(num)
        } else {
            right.add(num)
        }

        //rebalance
        if(left.size > right.size + 1){
            right.add(left.poll())
        }

        if(right.size > left.size + 1){
            left.add(right.poll())
        }
    }

    fun findMedian(): Double {
        return when{
            left.size > right.size ->{
                left.peek().toDouble()
            }
            right.size > left.size ->{
                right.peek().toDouble()
            }
            else -> {
                (right.peek().toDouble() + left.peek().toDouble()) / 2.0
            }
        }
    }
}
