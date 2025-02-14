// 17ms - O (Log n)
fun searchInsert17(nums: IntArray, target: Int): Int {
  if (nums.size == 1) {
      if (target > nums[0]) return 1
      return 0
  }
  if (target < nums[0]) return 0
  if (target > nums[nums.lastIndex]) return nums.size

  var p = nums.size / 2
  var s = 0
  var e = nums.lastIndex
  while (true) {
      if (nums[p] == target) return p
      if (nums[p] < target) {
          if (p == nums.lastIndex) return p+1
          if (s+1 == e) return e
          s = p
          p = (s+1+e) / 2
      } else {
          if (p == 0) return 0
          if (s != 0 && s+1 == e) return e
          e = p
          p = (e+s) / 2
      }
 
    }
}

// 15ms - move some comparison from while loop (reduce 2ms)
fun searchInsert15(nums: IntArray, target: Int): Int {
  if (target <= nums[0]) return 0
  if (target === nums[nums.lastIndex]) return nums.lastIndex
  if (target > nums[nums.lastIndex]) return nums.size

  var p = nums.size / 2
  var s = 0
  var e = nums.lastIndex
  while (s < e-1) {
      if (nums[p] == target) return p
      if (nums[p] < target) {
          s = p
          p = (s+1+e) / 2
      } else {
          e = p
          p = (e+s) / 2
      }
  }
  return e   
}

// 0ms - (not mine) but its time complexity is O (n). I think because the group of testcases
fun searchInsert(nums: IntArray, target: Int): Int {
        
  for(i in nums.indices){
      if(nums[i] == target){
          return i
      }else if(nums[i] > target){
          return i
      }
  }

  return nums.size

}
