fun romanToInt(input: String): Int {
  var result = 0
  var i = 0
  val lastIndex = input.length - 1

  while (i <= lastIndex) {
      val c = input[i]

      when {
          c == 'M' -> result += 1000
          c == 'D' -> result += 500
          c == 'C' -> {
              if (i < lastIndex) {
                  val nextC = input[i+1]
                  if (nextC == 'M') {
                      result += 900
                      i++
                  } else if (nextC == 'D') {
                      result += 400
                      i++
                  } else {
                      result += 100
                  }
              } else {
                  result += 100
              }
          }
          c == 'L' -> result += 50
          c == 'X' -> {
              if (i < lastIndex) {
                  val nextC = input[i+1]
                  if (nextC == 'C') {
                      result += 90
                      i++
                  } else if (nextC == 'L') {
                      result += 40
                      i++
                  } else {
                      result += 10
                  }
              } else {
                  result += 10
              }
          }
          c == 'V' -> result += 5
          c == 'I' -> {
              if (i < lastIndex) {
                  val nextC = input[i+1]

                  if (nextC == 'X') {
                      result += 9
                      i++
                  } else if (nextC == 'V') {
                      result += 4
                      i++
                  } else {
                      result++
                  }
              } else {
                  result += 1
              }
          }
      }
      i++
  }
  return result
}
