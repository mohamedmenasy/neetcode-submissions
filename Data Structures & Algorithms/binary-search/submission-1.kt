class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex

        while(left <= right){
            val mid = left + (right - left) / 2
            val num = nums[mid]
            if(num > target){
                right = mid - 1
            } else if(num < target){
                left = num + 1
            } else {
                return mid
            }
        }
        return -1
    }
}
