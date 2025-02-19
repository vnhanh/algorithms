// 19ms
fun mySqrt19(x: Int): Int {
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

// 1ms - create my list of input and then test output
fun mySqrt(x: Int): Int {
  var m = 0L
  var n = x.toLong()
  var i: Long = (x/2).toLong()
  var l: Long = 0L
  while(i >= m && i <= n) {
    if ((i * i).toLong() == x.toLong()) return i.toInt()
    if ((i * i).toLong() < x.toLong()) {
      m = i+1
      l = i
    } else {
      n = i-1L
    }
    i = (m+n) / 2
  }
  return l.toInt()
}

fun main() {
  // val input = 1085817232
  val input = 0
  val result = mySqrt(input)
  println(result)

  println(mySqrt(1))
  println(mySqrt(15))
}
