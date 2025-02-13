// Solution 1: 3447ms
inline fun check(l: String, r: String) : Boolean {
  var i = 0
  while (i < l.length) {
      if (l[l.lastIndex - i] != r [i]) return false
      i++
  }
  return true
}

fun shortestPalindrome3447(s: String): String {
  if(s.length < 2) return s
  var p = s.length/2
  var isOdd = 0
  while(p > 0) {
      if (p + p < s.length) {
          if (check(s.substring(0, p), s.substring(p+1))) {
              isOdd = 1
              println("odd case - p $p")
              break
          }
      }
      if (check(s.substring(0, p), s.substring(p))) {
          isOdd = 0
          println("even case - p $p")
          break
      }
      p--
  }

  return if (p == 0) "${s.substring(1).reversed()}$s" else "${s.substring(p+p+isOdd).reversed()}$s"
}

// Solution 2: 239ms, 325ms, 2281 - it's better to use index instead of substring()
inline fun check(s: String, m: Int, isOdd: Int) : Boolean {
  var i = 0
  while (i < m) {
      if (s[m-i-1] != s[m+isOdd+i]) return false
      i++
  }
  return true
}

inline fun check2(s: String, m: Int, isOdd: Int) : String? {
  var i = 0
  while (i < m) {
      if (s[m-i-1] != s[m+isOdd+i]) return null
      i++
  }
  return if (m+m+isOdd < s.length) s.substring(m+m+isOdd) else ""
}

inline fun shortestPalindrome(s: String): String {
  if(s.length < 2) return s
  var p = s.length/2
  var isOdd = 0
  while(p > 0) {
      if (p + p < s.length) {
          if (check(s, p, 1)) {
              isOdd = 1
              break
          }
      }
      if (check(s, p, 0)) break
      p--
  }

  return if (p == 0) "${s.substring(1).reversed()}$s" else "${s.substring(p+p+isOdd).reversed()}$s"
}

fun main() {
  // val s = "aacecaaa"
  val s = "abcd"
  println(shortestPalindrome3447(s))
}
