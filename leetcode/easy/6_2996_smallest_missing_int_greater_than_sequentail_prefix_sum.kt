// Bad: create a new ArrayList to contains need to check elements => increase memory + runtime
// Good: still use IntArray, can sort it -> avoid increasing memory + runtime
fun missingInteger(nums: IntArray): Int {
  if (nums.size == 1) return nums[0] + 1
  var i = 1
  var sum = nums[0]
  var isCheck = true
  var tempArr = arrayListOf<Int>()
  while (i < nums.size) {
      when {
          isCheck && nums[i] == nums[i-1]+1 -> {
              sum += nums[i]
          }
          isCheck -> {
              isCheck = false
              if (i == 1) sum++
              if (nums[i] >= sum) tempArr.add(nums[i])
          }
          else -> {
              if (nums[i] >= sum) tempArr.add(nums[i])
          }
      }
      i++
  }
  if (tempArr.isEmpty()) return sum
  val checkArr = tempArr.sorted()
  i = 0
  while (i < checkArr.size) {
      while (i < checkArr.size - 1) {
          if (checkArr[i+1] == checkArr[i]) i++ else break
      }
      if (checkArr[i] == sum) {sum++} else { return sum }
      i++
  }
  return sum
}

fun missingInteger2(nums: IntArray): Int {
  val nNums = nums.size

  var sum = nums[0]
  for(idx in 1 until nNums){
      if(nums[idx - 1] + 1 == nums[idx]){
          sum += nums[idx]
      }else{
          break
      }
  }

  nums.sort()
  for(num in nums){
      if(sum == num){
          ++sum
      }
  }
  
  return sum
}


fun main() {
  val nums: IntArray = intArrayOf(3,4,7,6,6,5,8,2,8,9,2,6)
  
  val result = missingInteger(nums)
  println(result)
}
