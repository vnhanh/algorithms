// Solution 1: 109ms (bad), take near 3 hours, must run logs to debug on VS Code
fun convert109(s: String, numRows: Int): String {
  if (s.length <= numRows || numRows == 1) return s
  val twoDimenList = mutableListOf<MutableList<Char>>()
  var i = 0
  var t = 0
  var j = 0
  var tL = mutableListOf<Char>()
  while(i < s.length) {
      when {
          (t / numRows) % (numRows - 1) == 0 -> tL.add(s[i++])
          (t % (numRows * (numRows - 1)) / numRows + t % numRows) == (numRows - 1) -> {
              tL.add(s[i++])
          }
          else -> tL.add(' ')
      }
      t++
      j++
      if (j == numRows || i == s.length) {
          twoDimenList.add(tL)
          // reset
          tL = mutableListOf<Char>()
          j = 0
      }
  }
  val m = twoDimenList.size
  val builder = StringBuilder()
  i = 0
  j = 0
  while (j < numRows) {
      if (j < twoDimenList[i].size) {
          if (twoDimenList[i][j] != ' ') {
              builder.append(twoDimenList[i][j])
          }
      }
      i++
      if (i == m) {
          j++
          i = 0
      }
  }
  return builder.toString()
}

/**
 * Solution 2 - 4ms, quite good
 */
fun convert(s: String, numRows: Int): String {
    if (s.length < numRows || numRows == 1) return s
    val builder = StringBuilder()
    var i = 0 
    var j: Int
    var oneStep = true
    while (i < numRows) {
        j = i
        while (j < s.length) {
            builder.append(s[j])
            when {
                i % (numRows - 1) == 0 -> {
                    j += 2 * (numRows - 1)
                }
                oneStep -> {
                    j += 2 * (numRows - 1) - 2 * i
                    oneStep = false
                }
                !oneStep -> {
                    j += 2 * i
                    oneStep = true
                }
            }
        }
        oneStep = true
        i++
    }

    return builder.toString()
}

fun main() {
  val input = "PAYPALISHIRING"
  println(convert(input, 3))
}
