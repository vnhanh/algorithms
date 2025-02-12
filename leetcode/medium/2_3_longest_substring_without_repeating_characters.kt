

import kotlin.intArrayOf

// 8ms - use HashMap
fun lengthOfLongestSubstring8(s: String): Int {
  if (s.isEmpty()) return 0
  var i = 1
  var blockBelow = 0
  var k = 1
  var t = 1
  val map = hashMapOf<Char,Int>()
  map[s[0]] = 0
  while (i < s.length) {
      val indexOfC = map[s[i]]
      if (indexOfC != null && indexOfC >= blockBelow) {
          // save k
          if (k < t) k = t
          t = i - indexOfC
          blockBelow = indexOfC
      } else {
          t++
      }
      map[s[i]] = i
      i++
  }
  return if (t > k) t else k
}

/**
 * 2ms - For loop to find the index of a specific character run faster than HashMap(put + get), OMG
 */
inline fun String.indexOfChar(c: Char, start: Int, end: Int) : Int {
  for (i in start..end) {
      if (this[i] == c) return i
  }
  return -1
}

fun lengthOfLongestSubstring2(s: String): Int {
  if (s.isEmpty()) return 0
  var i = 1
  var start = 0
  var k = 1
  var t = 1
  // val map = hashMapOf<Char,Int>()
  // map[s[0]] = 0
  while (i < s.length) {
      val indexOfC = s.indexOfChar(s[i], start, i-1)
      if (indexOfC != -1) {
          // save k
          if (k < t) k = t
          t = i - indexOfC
          start = indexOfC + 1
      } else {
          t++
      }
      // map[s[i]] = i
      i++
  }
  return if (t > k) t else k
}
