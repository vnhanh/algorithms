/**
 * Solution 1: 3ms
 */
fun myAtoi3(s: String): Int {
  var i = 0
  var n = 0
  var isNegative = false
  var startReadNumber = false
  while (i < s.length) {
      val m = s[i] - '0'
      when {
          s[i] == '-' && !startReadNumber -> {
              isNegative = true
              startReadNumber = true
          }
          s[i] == '+' && !startReadNumber-> {
              startReadNumber = true
          }
          m in 0..9 -> {
              if (!isNegative && (Int.MAX_VALUE/10 < n || (Int.MAX_VALUE - n*10) < m)) {
                  return Int.MAX_VALUE
              } else if (isNegative && (Int.MIN_VALUE/10 > -n || (Int.MIN_VALUE + n*10) > -m)) {
                  return Int.MIN_VALUE
              }
              n = n*10 + m
              startReadNumber = true
          }
          s[i] == ' ' && !startReadNumber -> Unit
          m !in 0..9 -> {
              return if (isNegative) -n else n
          }
          else -> return 0
      }
      i++
  }
  return if (isNegative) -n else n
}

/**
 * Solution 2: 1-2ms
 */
fun myAtoi(s: String): Int {
  var i = 0
  var n = 0
  var sign = 0

  while (i < s.length && s[i] == ' ') i++
  if (i == s.length) return 0
  if (s[i] == '+') {
      i++
  } else if (s[i] == '-') {
      i++
      sign = 1
  }
  
  var m: Int
  while (i < s.length && (s[i] - '0') in 0..9) {
      m = s[i] - '0'
       if (n > Int.MAX_VALUE/10 || (n == Int.MAX_VALUE/10 && m >= 7 + sign)) {
          if (sign == 0) return Int.MAX_VALUE
          return Int.MIN_VALUE
      }
      n = n*10 + m
      
      i++
  }

  sign = if (sign == 0) 1 else -1
  return sign * n
}
