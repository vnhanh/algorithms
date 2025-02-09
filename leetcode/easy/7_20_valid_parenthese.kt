// ArrayList.removeAt() works well with stack.pop()
// when - case each element runs faster than when - case with a group of values (i.e '(', '{', '[]'})
fun isValid(s: String): Boolean {
  val first = s[0]
  if (s.length == 0 || s.length % 2 == 1 || (first != '(' && first != '{' && first != '[')) return false
  val t = arrayListOf<Char>()
  t.add(first)
  var i = 1
  while(i < s.length) {
      val c = s[i]
  
      when(c) {
          '(' -> {
              t.add(c)
          }
          '{' -> t.add(c)
          '[' -> t.add(c)
          ')' -> {
              if (t.isEmpty()) return false
              if (t.removeAt(t.lastIndex) != '(') return false
          }
          '}' -> {
              if (t.isEmpty()) return false
              if (t.removeAt(t.lastIndex) != '{') return false
          }
          ']' -> {
              if (t.isEmpty()) return false
              if (t.removeAt(t.lastIndex) != '[') return false
          }
      }
      i++
  }
  return t.isEmpty()
}
