
class ListNode(
    val `val`: Int
) {
    var next: ListNode? = null
 }

 class Solution {
  // mid level problem of leetcode seems like is easier than hackerank
  fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null && l2 == null) return null
    if (l1 == null) return l2
    if (l2 == null) return l1

    var buff = 0
    val firstSum = l1.`val` + l2.`val`
    val firstNode = if (firstSum >= 10) {
      buff = 1
      ListNode(firstSum - 10)
    } else {
      ListNode(firstSum)
    }
    var c:ListNode = firstNode
    var inputNode1 = l1.next
    var inputNode2 = l2.next
    while (inputNode1 != null || inputNode2 != null) {
        val sum = (inputNode1?.`val` ?: 0) + (inputNode2?.`val` ?: 0) + buff
        val next = if (sum >= 10) {
          buff = 1
          ListNode(sum - 10)
        } else {
          buff = 0
          ListNode(sum)
        }
        
        inputNode1 = inputNode1?.next
        inputNode2 = inputNode2?.next
        c.next = next
        c = next
    }
    if (buff == 1) c.next = ListNode(1)
    return firstNode
  }
}

fun main() {
  val solution = Solution()
  val firstNodes = ListNode(1)
  firstNodes.next = ListNode(2)
  val secondNodeList = ListNode(7)
  secondNodeList.next = ListNode(8)
  val result = solution.addTwoNumbers(firstNodes, secondNodeList)
  println(result?.`val`)
}
