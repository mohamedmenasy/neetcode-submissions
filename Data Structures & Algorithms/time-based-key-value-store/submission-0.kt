class TimeMap() {
    private val store = mutableMapOf<String, MutableList<Pair<Int, String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        store.getOrPut(key) { mutableListOf() }.add(timestamp to value)
    }

    fun get(key: String, timestamp: Int): String {
        val values = store[key] ?: return ""
        var left = 0
        var right = values.lastIndex
        var result = ""

        while(left <= right){
            val mid = left + (right - left) / 2
            val storedTimestamp = values[mid].first
            if(storedTimestamp <= timestamp){
                result = values[mid].second
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return result
    }
}
