fun mySqrt(x: Int): Int {
  if (x == 0) return 0
  if (x < 4) return 1
  if (x < 9) return 2

  var i = 1
  var m: Int
  do {
      m = x / i / i
      when {
          m >= 9 -> i = i * 3
          m >= 4 -> i = i * 2
          m >= 2 -> i = i * 141 / 100
          i < 46340 && x >= (i+1) * (i+1) -> i++
          else -> return i
      }
  } while (m > 0)
  return i
}

fun main() {
  val input = 1085817232
  val result = mySqrt(input)
  println(result)
}
