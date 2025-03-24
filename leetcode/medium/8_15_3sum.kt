/**
 * Solution 1: 200-253ms
 */
fun threeSum200(nums: IntArray): List<List<Int>> {
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

/**
 * Solution 2: (O)n logn
 */
fun threeSum(nums: IntArray): List<List<Int>> {
    if (nums.size == 3) {
        if (nums[0] + nums[1] + nums[2] == 0) return listOf(nums.toList())
        return emptyList()
    }
    nums.sort()

    val result = mutableListOf<List<Int>>()
    val n = nums.size
    var l: Int
    var h: Int
    var m: Int
    
    for (i in 0..n-3) {
        l = i+1
        h = n-1
        while (l < h) {
            m = (l + h) / 2
            when {
                nums[l] + nums[h] > -nums[i] -> h = m - 1
                nums[l] + nums[h] < -nums[i] -> l = m + 1
                else -> {
                    result.add(listOf(nums[i], nums[l], nums[h]))

                    l++
                    h--
                    while (l < h && nums[l] == nums[l-1]) l++
                    while (l < h && nums[h] == nums[h+1]) h--
                }
            }
        }
    }

    return result
}

/**
 * Solution 2: 92ms (lower-midrange)
 */
fun threeSum92(nums: IntArray): List<List<Int>> {
    if (nums.size == 3) {
        if (nums[0] + nums[1] + nums[2] == 0) return listOf(nums.toList())
        return emptyList()
    }
    nums.sort()

    val result = mutableListOf<List<Int>>()
    val n = nums.size
    var l: Int
    var h: Int
    
    for (i in 0..n-3) {
        if (i > 0 && nums[i] == nums[i-1]) continue
        l = i+1
        h = n-1
        while (l < h) {
            when {
                nums[l] + nums[h] < -nums[i] -> {
                    do {
                        l++
                    } while (l < h && nums[l] == nums[l-1])
                }
                nums[l] + nums[h] > -nums[i] -> {
                    do {
                        h--
                    } while (l < h && nums[h] == nums[h+1])
                }
                else -> {
                    result.add(listOf(nums[i], nums[l], nums[h]))
                    do {
                        l++
                    } while (l < h && nums[l] == nums[l-1])
                    do {
                        h--
                    } while (l < h && nums[h] == nums[h+1])
                }
            }
        }
    }

    return result
}

/**
 * Solution 2 with better code for filter input data, it works well with the test samples
 */
fun threeSum77(nums: IntArray): List<List<Int>> {
    if (nums.size == 3) {
        if (nums[0] + nums[1] + nums[2] == 0) return listOf(nums.toList())
        return emptyList()
    }
    nums.sort()

    val result = mutableListOf<List<Int>>()
    val n = nums.size
    var l: Int
    var h: Int
    val min = nums[0] + nums[1]
    val max = nums[n-1] + nums[n-2]
    
    for (i in 0..n-3) {
        if (i > 0 && nums[i] == nums[i-1]) continue
        if (-nums[i] < min || -nums[i] > max) continue
        if (nums[i] + nums[i+1] + nums[i+2] > 0) break 
        l = i+1
        h = n-1

        while (l < h) {
            when {
                nums[l] + nums[h] < -nums[i] -> {
                    do {
                        l++
                    } while (l < h && nums[l] == nums[l-1])
                }
                nums[l] + nums[h] > -nums[i] -> {
                    do {
                        h--
                    } while (l < h && nums[h] == nums[h+1])
                }
                else -> {
                    result.add(listOf(nums[i], nums[l], nums[h]))
                    do {
                        l++
                    } while (l < h && nums[l] == nums[l-1])
                    do {
                        h--
                    } while (l < h && nums[h] == nums[h+1])
                }
            }
        }
    }

    return result
}

// This one improve by applying ArrayList instead of List, remove checking min
fun threeSum45(nums: IntArray): List<List<Int>> {
    nums.sort()

    val result = ArrayList<ArrayList<Int>>()
    val n = nums.size
    
    val max = nums[n-1] + nums[n-2]
    
    for (i in 0..n-3) {
        if (i > 0 && nums[i] == nums[i-1]) continue
        if (-nums[i] > max) continue
        if (nums[i] + nums[i+1] + nums[i+2] > 0) break 
        var l = i+1
        var h = n-1

        while (l < h) {
            when {
                nums[l] + nums[h] < -nums[i] -> {
                    l++
                }
                nums[l] + nums[h] > -nums[i] -> {
                    h--
                }
                else -> {
                    val nl = ArrayList<Int>().apply {
                        add(nums[i])
                        add(nums[l++])
                        add(nums[h--])
                    }
                    result.add(nl)
                    while (l < h && nums[l] == nums[l-1]) l++
                    while (l < h && nums[h] == nums[h+1]) h--
                }
            }
        }
    }

    return result
}

fun main() {
  println(threeSum(intArrayOf(-1,0,1,2,-1,-4)).joinToString("-"))
}
