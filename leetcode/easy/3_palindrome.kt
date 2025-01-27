class Solution {
  // x.toString() takes longer time than
  fun isPalindrome(x: Int): Boolean {
      if (x < 0) return false
      if (x < 10) return true
      var t = x
      var r = 0
      while (t != 0) {
          r = r * 10 + t % 10
          t = t / 10
      }
      return r == x
  }
}
