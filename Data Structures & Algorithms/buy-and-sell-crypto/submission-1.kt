class Solution {
    fun maxProfit(prices: IntArray): Int {
        var minPrice = prices[0]
        var maxProfit = 0

        for(price in prices){
            val profit = price - minPrice
            maxProfit = maxOf(maxProfit, profit)
            minPrice = minOf(minPrice, price)
        }

        return maxProfit
    }
}
