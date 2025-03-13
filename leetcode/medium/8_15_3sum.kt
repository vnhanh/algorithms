/**
 * Solution 1: 200-253ms
 */
fun threeSum(nums: IntArray): List<List<Int>> {
  if (nums.size == 3) {
      if (nums[0] + nums[1] + nums[2] == 0) return listOf(nums.toList())
      return emptyList()
  }
  nums.sort()
  if (nums[0] > 0) return emptyList()
  if (nums[nums.lastIndex] < 0) return emptyList()
  val result = mutableListOf<List<Int>>()
  val n = nums.size
  for (i in 0..n-3) {
      if (i > 0 && nums[i] == nums[i-1]) continue
      for (j in (i+1)..n-2) {
          if (j > i+1 && nums[j] == nums[j-1]) continue
          val target = nums[i] + nums[j]
          val index = binarySearch(nums, j+1, n-1, -1 * target)
          if (index != -1) {
              result.add(listOf(nums[i], nums[j], nums[index]))
          }
      }
  }
  return result
}

fun binarySearch(nums: IntArray, start: Int, end: Int, target: Int) : Int {
  var l = start
  var h = end
  while (l <= h) {
      val m = (l+h)/2
      if (nums[m] == target) return m
      if (nums[m] < target) {
          l = m+1
      } else {
          h = m-1
      }
  }
  return -1
}

fun main() {
  
}
