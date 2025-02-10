/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 */
class ListNode(var `val`: Int) {
  var next: ListNode? = null
}

// takes 1 ms on leetcode
// to take 0 ms -> use recursive but I don't like it because it increase memory heap
// use !! to increase speed =))
fun mergeTwoLists(t1: ListNode?, t2: ListNode?): ListNode? {
  if (t1 == null) return t2
  if (t2 == null) return t1
  var h: ListNode
  var p: ListNode
  var list1: ListNode? = t1
  var list2: ListNode? = t2
  if (t1.`val` < t2.`val`) {
      h = ListNode(t1.`val`)
      p = h
      list1 = list1?.next
  } else {
      h = ListNode(t2.`val`)
      p = h
      list2 = list2?.next
  }

  do {
      val l1 = list1?.`val` ?: 101
      val l2 = list2?.`val` ?: 101
      when {
          l1 < l2 -> {
              p.next = ListNode(l1)
              p = p.next!!
              list1 = list1!!.next
          }
          else -> {
              p.next = ListNode(l2)
              p = p.next!!
              list2 = list2!!.next
          }
      }
  } while (list1 != null || list2 != null)

  // while (list1 != null || list2 != null) {
  //     when {
  //         list1 == null -> {
  //             p.next = list2
  //             p = p.next
  //             list2 = list2!!.next
  //         }
  //         list2 == null -> {
  //             p?.next = list1
  //             p = p.next
  //             list1 = list1!!.next
  //         }
  //         list1!!.`val` < list2.`val` -> {
  //             p.next = ListNode(list1!!.`val`)
  //             p = p.next
  //             list1 = list1?.next
  //         }
  //         else -> {
  //             p.next = ListNode(list2!!.`val`)
  //             p = p.next
  //             list2 = list2?.next
  //         }
  //     }
  // }
  return h
}
