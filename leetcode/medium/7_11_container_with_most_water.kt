/**
 * Solution 1: 66ms
 */
fun maxArea66(height: IntArray): Int {
  if (height.size == 2) {
      return min(height[0],height[1])
  }
  var max = min(height[0],height[1])
  for (i in 0..height.size-2) {
      if(height[i] == 0) continue
      for (j in (max/height[i] + i)..height.size-1) {
          val s = min(height[i], height[j])
          if (max < s * (j-i)) max = s * (j-i)
      }
  }
  return max
}

/**
 * Solution 2: 14ms. Use 2 pointers at 2 endpoints of the array
 */
fun maxArea14(height: IntArray): Int {
  if (height.size == 2) {
      return min(height[0],height[1])
  }

  var max = 0
  var l = 0 
  var h = height.lastIndex
  var m: Int
  while (l < h) {
      m = min(height[l], height[h])
      val t = (h - l) * m
      if (max < t) {
          max = t
      }
      if (height[l] < height[h]) {
          do {
              l++
          } while(height[l] <= m && h > l)
      } else {
          do {
              h--
          } while(height[h] <= m && h > l)
      }
  }
  return max
}
