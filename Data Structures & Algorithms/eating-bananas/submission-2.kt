class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var left = 1 // slowest speed
        var right = piles.maxOrNull()!! // max speed
        var answer = right

        while(left <= right){
            val speed = left + (right - left) / 2
            var totalHours = 0L

            for (pile in piles){
                totalHours += (pile.toLong() + speed - 1) / speed
            }

            if(totalHours <= h){
                answer = speed
                right = speed - 1
            } else {
                left = speed + 1
            }
        }
        return answer

    }
}
