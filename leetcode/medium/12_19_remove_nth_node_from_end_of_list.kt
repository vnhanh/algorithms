/**
 * Solution: very normal
 */
fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
  var h: ListNode? = null
  var p: ListNode? = head
  var counter = 0
  while (p != null) {
      counter++
      p = p.next
  }
  val expectedIndex = counter - n + 1
  if (expectedIndex == 1) return head?.next
  counter = 0
  p = head
  while (p != null) {
      counter++
      when {
          counter == expectedIndex - 1 -> {
              h = p
          }
          counter == expectedIndex -> {
              h?.next = p?.next
              break
          }
      }
      p = p.next
  }
  return head
}

fun main() {

}
