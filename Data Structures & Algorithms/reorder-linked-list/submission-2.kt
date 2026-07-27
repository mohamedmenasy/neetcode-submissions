/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        var slow = head
        var fast = head

        while(fast?.next != null && fast.next?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }

        var second = slow?.next
        slow?.next = null
        var previous: ListNode? = null

        while(second != null){
            val nextNode = second.next
            second.next = previous
            previous = second
            second = nextNode
        }

        var first = head
        var secondHalf = previous

        while(secondHalf != null){
            val firstNext = first?.next
            val secondNext = secondHalf?.next

            first?.next = secondHalf
            secondHalf.next = firstNext

            first = firstNext
            secondHalf = secondNext
        }

    }
}
