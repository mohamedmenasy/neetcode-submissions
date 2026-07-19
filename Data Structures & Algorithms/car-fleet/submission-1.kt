class Solution {
    //O(n log n)
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        var fleet = 0
        var lastFleetTime = 0.0

        val cars = position.indices
                    .map { i -> position[i] to speed[i] }
                    .sortedByDescending{ it.first }
        for((posistion, speed) in cars){
            val time = (target - posistion).toDouble() / speed
            if(time > lastFleetTime){
                fleet++
                lastFleetTime = time
            }
        }
        return fleet
    }
}
