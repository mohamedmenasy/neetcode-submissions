class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val output = IntArray(nums.size)
        var prefix = 1
        var suffix = 1
        for(i in nums.indices){
            output[i] = prefix
            prefix *= nums[i]
        }

        for(i in nums.indices.reversed()){
            output[i] *= suffix
            suffix *= nums[i]
        }
        return output
    }
}
