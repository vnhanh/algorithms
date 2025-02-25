import kotlin.math.min

/**
 * Solution 1: 10ms (bad). The issue was resolved by dynamic programming, it took me about 4 days :((
 * Need to find other solutions
 */
inline fun greatestCommonDivisor(p: Int, q: Int) : Int {
  if (p == 1 || q == 1) return 1
  if (p % q == 0) return q
  if (q % p == 0) return p
  var r = min(p,q)/2
  while(r > 1) {
      if (p % r == 0 && q % r == 0) return r
      r--
  }
  return r
}

inline fun climbStairs(n: Int): Int {
  if (n == 1) return 1
  if (n == 2) return 2
  if (n == 3) return 3
  val arr = arrayListOf<Int>()
  arr.add(1)
  arr.add(2)
  var commonDivisor = 1

  for (m in 4..n) {
      if (m % 2 == 1){
          for(i in 1..(m/2)) {
              commonDivisor = greatestCommonDivisor(arr[i], (m-2*i))
              if (commonDivisor == 1) {
                  commonDivisor = greatestCommonDivisor(m-i, (m-2*i))
                  val d = (m-2*i) / commonDivisor
                  arr[i] = (m-i) / commonDivisor  * arr[i] / d
              } else {
                  val d = (m-2*i) / commonDivisor
                  arr[i] = (arr[i] / commonDivisor)  * (m-i) / d
              }
          }
      } else {
          for(i in 1..((m-2)/2)) {
              commonDivisor = greatestCommonDivisor(arr[i], (m-2*i))
              if (commonDivisor == 1) {
                  commonDivisor = greatestCommonDivisor(m-i, (m-2*i))
                  val d = (m-2*i) / commonDivisor
                  arr[i] = (m-i) / commonDivisor * arr[i] / d
              } else {
                  val d = (m-2*i) / commonDivisor
                  arr[i] = (arr[i] / commonDivisor) * (m-i) / d 
              }
              
          }
          arr.add(1)
      }
  }
  return arr.sum()
}

fun main() {
  println(climbStairs(45))
}
