// 1ms
fun removeDuplicates(nums: IntArray): Int {
  var k = 1
  var i = 1
  while (i < nums.size) {
      if (nums[i] != nums[i-1]) {
          k++
          nums[k-1] = nums[i]
      }
      i++
  }
  
  return k
}
