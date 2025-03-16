/**
 * Solution 1: 97ms (bad)
 */
fun threeSumClosest97(nums: IntArray, target: Int): Int {
  val n = nums.size
  if (n == 3) return nums[0] + nums[1] + nums[2]
  nums.sort()
  var u = nums[0] + nums[1] + nums[2]
  for (i in 0..n-3) {
      for (j in i+1..n-2) {
          val s = target - nums[i] - nums[j]
          val t = binarySearch(nums, j+1, n-1, s)
          if (isNearer(target, u, nums[i] + nums[j] + t)) {
              u = nums[i] + nums[j] + t
          }
      }
  }
  return u
}

/** 
  Find the closet value
*/
private fun binarySearch(nums: IntArray, start: Int, end: Int, target: Int) : Int {
  var l = start
  var h = end
  var nearestValue: Int = nums[start]
  var m: Int
  while (l <= h) {
      m = (l+h)/2
      when {
          nums[m] == target -> return target
          nums[m] > target -> {
              if (isNearer(target, nearestValue, nums[m])) {
                  nearestValue = nums[m]
              }
              h = m-1
          }
          else -> {
              if (isNearer(target, nearestValue, nums[m])) {
                  nearestValue = nums[m]
              }
              l = m+1
          }
      }
  }
  return nearestValue
}

private fun isNearer(target: Int, old: Int, new: Int) : Boolean {
  if (old == new) return false
  return when {

      (old <= 0 && target <= 0) || (old >= 0 && target >= 0) -> {
          val diff = target - old
          val s = target + diff
          (s < old && new > s && new < old) || (s > old && new < s && new > old)
      }

      // target and new are the same sign
      else -> {
          val diff = target - new
          val t = target + diff
          (t < new && (old < t || old > new)) || (t > new && (old < new || old > t))
      }
  }
}

fun main() {

}
