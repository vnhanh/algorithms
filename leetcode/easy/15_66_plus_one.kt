// 16ms
fun plusOne16(digits: IntArray): IntArray {
  var n = 1
  for (i in digits.lastIndex downTo 0) {
      when {
          n == 0 -> Unit
          n == 1 && digits[i] == 9 -> digits[i] = 0
          n == 1 -> {
              digits[i] = digits[i] + 1
              break
          }
      }
  }
  if (n == 0) return digits
  return IntArray(digits.size + 1) { i ->
      if (i == 0) {
          1
      } else {
          digits[i-1]
      }
  }
}

// 15ms
fun plusOne15(digits: IntArray): IntArray {
  var n = 1
  for (i in digits.lastIndex downTo 0) {
      when {
          n == 1 && digits[i] == 9 -> digits[i] = 0
          n == 1 -> {
              digits[i] = digits[i] + 1
              break
          }
          else -> break
      }
  }
  if (n == 0) return digits
  return intArrayOf(1) + digits
}

// oms - not use n variable
fun plusOne(digits: IntArray): IntArray {
  for (i in digits.size-1 downTo 0) {
      when {
          digits[i] == 9 -> digits[i] = 0
          else -> {
              digits[i] = digits[i] + 1
              return digits
          }
      }
  }

  val r = IntArray(digits.size + 1)
  r[0] = 1
  return r
}
