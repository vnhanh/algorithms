import kotlin.math.max

// 3ms - hard to read - we can use char - char to convert to integer value - 36.03MB
inline fun process(a: String, b: String) : String {
  val arr = CharArray(max(a.length, b.length))
  var n = 0
  for (i in 0 until a.length) {
      if (i < b.length) {
          if (a[a.length - 1 - i] == '1' && b[b.length - 1 - i] == '1') {
              if (n == 1) {
                  arr[a.length - 1 - i] = '1'
              } else {
                  arr[a.length - 1 - i] = '0'
                  n = 1
              }
          } else if(a[a.length - 1 - i] != b[b.length - 1 - i]) {
              if (n == 1) {
                  arr[a.length - 1 - i] = '0'
              } else {
                  arr[a.length - 1 - i] = '1'
              }
          } else {
              if (n == 1) {
                  arr[a.length - 1 - i] = '1'
                  n = 0
              } else {
                  arr[a.length - 1 - i] = '0'
              }
          }
      } else {
          if (n == 1) {
              if (a[a.length - 1 - i] == '1') {
                  arr[a.length - 1 - i] = '0'
              } else {
                  arr[a.length - 1 - i] = '1'
                  n = 0
              }
          } else {
              arr[a.length - 1 - i] = a[a.length - 1 - i]
          }
      }
  }
  if (n == 1) {
      return String(CharArray(arr.size + 1) { if (it == 0) '1' else arr[it-1]})
  }
  return String(arr)
}

inline fun addBinary3(a: String, b: String): String {
  return if (a.length > b.length) {
      process(a, b)
  } else {
      process(b,a)
  }
}

// 2ms (not mine)
fun addBinary2(a: String, b: String): String {
  val result = StringBuilder()
  var i = a.length - 1
  var j = b.length - 1
  var carry = 0
  
  while (i >= 0 || j >= 0 || carry > 0) {
      val sum = (if (i >= 0) a[i] - '0' else 0) + 
                (if (j >= 0) b[j] - '0' else 0) + 
                carry
      
      result.append(sum % 2)
      carry = sum / 2
      i--
      j--
  }
  
  return result.reverse().toString()
}

// 2ms (mine - write in a way makes sense to me) - 35.94MB
inline fun addBinary(a: String, b: String): String {
  val maxLength = max(a.length, b.length) + 1
  val arr = CharArray(maxLength)
  var k = maxLength - 1
  var n = 0
  for (i in 0 until maxLength) {
      val aBit = if (i < a.length) a[a.length - 1 - i] - '0' else 0
      val bBit = if (i < b.length) b[b.length - 1 - i] - '0' else 0
      val s = aBit + bBit + n
      n = s/2
      arr[k--] = '0' + (s and 1)
  }
  if(arr[0] == '1') {
      return String(arr, 0 , maxLength)
  }
  return String(arr, 1, maxLength - 1)
}

fun main() {
  val r = addBinary("11", "1")
  println(r)
}
