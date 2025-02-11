// 2ms
fun moveZeroes(nums: IntArray): Unit {
  var i = 0
  for (num in nums) {
      if (num == 0) continue
      nums[i++] = num
  }
  while(i < nums.size) {
      nums[i++] = 0
  }
}

fun main() {
  val nums = intArrayOf(1,2,3,0,0,7,8)
  moveZeroes(nums)
  println(nums.joinToString("-"))
}
