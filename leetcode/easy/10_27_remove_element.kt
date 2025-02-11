// 15ms
fun removeElement15(nums: IntArray, `val`: Int): Int {
  if (nums.size == 0) return 0
  if (`val` > 50) return nums.size
  // nums.size >= 1
  var i = 0
  var j = nums.lastIndex
  var k = 0
  while (i <= j) {
      if (nums[i] == `val`) {
          if (i == j) return k
          while (nums[j] == `val`) {
              j--
              if (i == j) return k
          }
          k++
          nums[i] = nums[j]
          j--
      } else {
          k++
      }
      i++
  }
  return k
}

// 9ms
fun removeElement9(nums: IntArray, `val`: Int): Int {
  if (nums.size == 0) return 0
  if (`val` > 50) return nums.size
  var i = 0
  var k = 0
  while (i < nums.size) {
      if (nums[i] == `val`) {
          nums[i] = 51
      } else {
          k++
      }
      i++
  }
  nums.sort()
  return k
}

// 0ms - not mine
fun removeElement0(nums: IntArray, `val`: Int): Int {
  var i = 0
  for (j in 0 until nums.size) {
      if (nums[j] == `val`) continue
      nums[i++] = nums[j]
  }
  return i
}
