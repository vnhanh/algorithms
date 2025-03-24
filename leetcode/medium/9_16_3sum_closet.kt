import kotlin.math.*

/**
 * Solution 1: 97ms (bad). (O)n^2
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
              if (abs(target - nearestValue) > abs(target - nums[m])) {
                  nearestValue = nums[m]
              }
              h = m-1
          }
          else -> {
              if (abs(target - nearestValue) > abs(target - nums[m])) {
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
/**
 * Solution 2: (O)n^2 (lower midrange). The best has time complexity about 14ms
 */
fun threeSumClosest41(nums: IntArray, target: Int): Int {
    val n = nums.size
    if (n == 3) return nums[0] + nums[1] + nums[2]
    nums.sort()
    var c = nums[0] + nums[1] + nums[2]
    var l: Int
    var h: Int
    val min = nums[1] + nums[2]
    val max = nums[n-1] - nums[n-2]

    for (i in 0..n-3) {
        if (i > 0 && nums[i] == nums[i-1]) continue
        l = i+1
        h = n-1
        val cur = nums[i]
        val remain = target - cur
        // if (abs(remain-nums[l]-nums[l+1]) > abs(target-c)) break

        while (l < h) {
            if (abs(remain-nums[l]-nums[h]) < abs(target-c)) c = cur+nums[l]+nums[h]
            when {
                nums[l] + nums[h] < remain -> {
                    l++
                }
                nums[l] + nums[h] > remain -> {
                    h--
                }
                else -> return target
            }
        }
    }
    return c
}

/**
 * Same solution with the above, but improve the speed by using sum instead of remain
 */
fun threeSumClosest22(nums: IntArray, target: Int): Int {
    val n = nums.size
    if (n == 3) return nums[0] + nums[1] + nums[2]
    nums.sort()
    var c = 0
    var minDiff = Int.MAX_VALUE

    for (i in 0..n-3) {
        if (i > 0 && nums[i] == nums[i-1]) continue
        var l = i+1
        var h = n-1

        while (l < h) {
            val sum = nums[i] + nums[l] + nums[h]
            val diff = abs(target-sum)
            if (diff == 0) return target
            if (diff < minDiff) {
                c = sum
                minDiff = diff
            }
            if (sum < target) {
                l++
            } else {
                h--
            }
        }
    }
    return c
}

fun main() {

}
