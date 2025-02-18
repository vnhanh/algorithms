fun longestPalindrome(s: String): String {
  if (s.length == 1) return s
  if (s.length == 2) {
      if (s[0] == s[1]) return s
      return s.substring(0,1)
  }
  var m = 0
  var n = 0
  var e = 0
  var s1 = 0
  var s2 = 0
  for (i in 0 until s.lastIndex) {
      if (i > 0 && s[i-1] == s[i+1]) {
          m = i - 1
          n = i + 1
          
          while (m > 0 && n < s.lastIndex && s[m-1] == s[n+1]) {
              m--
              n++
          }
          if (e < n - m) {
              e = n - m
              s1 = m
              s2 = n
          }
      }

      if (s[i] == s[i+1]) {
          m = i
          n = i + 1
          while (m > 0 && n < s.lastIndex && s[m-1] == s[n+1]) {
              m--
              n++
          }
          if (e < n - m) {
              e = n - m
              s1 = m
              s2 = n
          }
      }
  }

  return s.substring(s1, s2+1)
}

fun main() {
  val input = "cbbd"
  println(longestPalindrome(input))
}
