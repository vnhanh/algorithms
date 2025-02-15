// 0ms
fun lengthOfLastWord(s: String): Int {
  var e = s.length - 1
  while (e > -1 && s[e] == ' ') {
      e--
  }
  if (e == -1) return 0
  var i = e - 1
  while (i > -1 && s[i] != ' ') i--
  return e-i
}
