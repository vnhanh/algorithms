// 182ms - 160ms - group of lowest ones
fun reverse182(x: Int): Int {
  var arr = arrayListOf<Int>()
  var t = if (x < 0) -x else x
  while(t > 0) {
      arr.add(t%10)
      t = t/10
  }

  // if add this line => 160ms, beats 31.82% about space complexity
  if (arr.size == 10 && arr[0] > 2) return 0
  var r: Int = 0
  var i = arr.lastIndex
  var b = 1
  while (i > -1) {
      t = b * arr[i]
      if (arr[i] != 0 && t < b) return 0
      t = r + t
      if (t < r) return 0
      r = t
      b *= 10
      i--
  }
  if (x < 0) return -r
  return r
}

// 140ms - reduce to run 1 while loop only
fun reverse140(x: Int): Int {
  var t = if (x < 0) -x else x
  var i = 0
  var m: Int
  while(t > 0) {
      if (i > 214_748_364) return 0
      i = i*10
      m = i + t%10
      if (m < i) return 0
      i = m
      t = t/10
  }
  if (x < 0) return -i
  return i
}

fun main() {
  // println(reverse(1534236469))
  val i: Int = 646324351
  println(i * 10)
}
