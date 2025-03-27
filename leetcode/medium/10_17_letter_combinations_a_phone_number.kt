/**
 * Solution 1: 4ms. Brute force
 */
fun letterCombinations4(digits: String): List<String> {
  val map = hashMapOf<Char,String>(
      '2' to "abc",
      '3' to "def",
      '4' to "ghi",
      '5' to "jkl",
      '6' to "mno",
      '7' to "pqrs",
      '8' to "tuv",
      '9' to "wxyz"        
  )
  val res: ArrayList<String> = arrayListOf()
  val t: ArrayList<String> = arrayListOf()
  for (d in digits) {
      val chars: String? = map[d]
      if (chars == null) continue
      if (res.isEmpty()) {
          for (c in chars) {
              t.add(c.toString())
          }
      } else {
          for (str in res) {
              for (c in chars) {
                  t.add("$str${c.toString()}")
              }
          }
      }

      res.clear()
      res.addAll(t)
      t.clear()
  }
  return res
}

/**
 * Solution 2: 1ms - use Array for faster than Map
 */
val map = arrayOf("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")

fun letterCombinations1(digits: String): List<String> {
    val res: ArrayList<String> = arrayListOf()
    val t: ArrayList<String> = arrayListOf()
    for (d in digits) {
        val pos = d - '2'
        for (c in map[pos]) {
            if (res.isEmpty()) {
                t.add(c.toString())
            } else {
                for (str in res) {
                    t.add(str + c.toString())
                }
            }
        }
        res.clear()
        res.addAll(t)
        t.clear()
    }
    return res
}

fun main() {

}
