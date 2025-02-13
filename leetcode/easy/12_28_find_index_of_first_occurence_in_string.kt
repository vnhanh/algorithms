// 1ms
fun strStr(haystack: String, needle: String): Int {
  if (haystack.length < needle.length) return -1
  var i = 0
  for(i in 0..(haystack.length - needle.length)) {
      if (haystack.substring(i, needle.length + i) == needle) return i
  }
  return -1
}
