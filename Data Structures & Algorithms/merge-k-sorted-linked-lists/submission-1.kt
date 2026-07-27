/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if(lists.isEmpty()) return null
        var currentList = lists.toList()

        while(currentList.size > 1) {
            val mergedLists = mutableListOf<ListNode?>()
            var i = 0
            while(i < currentList.size) {
                val first = currentList[i]
                val second = if (i + 1 < currentList.size){
                    currentList[i + 1]
                } else {
                    null
                }
                mergedLists.add(mergeTwoLists(first, second))

                i += 2
            }
            currentList = mergedLists
        }
        return currentList[0]
    }

    fun mergeTwoLists(list1: ListNode?,list2: ListNode?): ListNode? {
        var first = list1
        var second = list2

        var dummy = ListNode(0)
        var current = dummy

        while(first != null && second != null){
            if(first!!.`val` <= second!!.`val`){
                current.next = first
                first = first.next
            } else {
                current.next = second
                second = second.next
            }
            current = current.next!!
        }
        
        current.next = first ?: second

        return dummy.next
    }
}
