class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val numsSet = hashSetOf<Int>()
        for(num in nums){
            if(numsSet.contains(num)){
                return true
            }
            numsSet.add(num)
        }
        return false
    }
}
