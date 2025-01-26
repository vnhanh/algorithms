class Solution {
  fun twoSum(nums: IntArray, target: Int): IntArray {
      val map: MutableMap<Int,Int> = mutableMapOf()
      nums.forEachIndexed { key, value ->
          map[target - value]?.let { 
              if (it != key) return intArrayOf(it, key)
          }
          map[value] = key
      }
      return intArrayOf()
  }

}

fun main() {
  val result = Solution().twoSum(intArrayOf(3,2,4), 6)
  println(result.joinToString("-"))
}
