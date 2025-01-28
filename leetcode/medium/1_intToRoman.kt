// Solution 1: takes 1 ms
val symbols = arrayOf(
    1000 to "M",
    900 to "CM",
    500 to "D",
    400 to "CD",
    100 to "C",
    90 to "XC",
    50 to "L",
    40 to "XL",
    10 to "X",
    9 to "IX",
    5 to "V",
    4 to "IV",
    1 to "I",
)

// it reduces 1 ms
@JvmField
val numerals = Array(4000) { convert(it) }

fun convert(num: Int): String = buildString {
    symbols.fold(num) { acc, (n, str) ->
        val times = acc / n
        // it reduces time
        for (i in 0..times) append(str)
        acc - n * times
    }
}

inline fun Any?.intToRoman(num: Int): String = numerals[num]

// Solution 2: takes 3 ms
fun intToRoman2(num: Int): String {
    var result = StringBuilder()
    var t = num
    while (t > 0) {
        when {
            t >= 1000 -> {
                result.append("M")
                t -= 1000
            }
            t >= 900 -> {
                result.append("CM")
                t -= 900
            }
            t >= 500 -> {
                result.append("D")
                t -= 500
            }
            t >= 400 -> {
                result.append("CD")
                t -= 400
            }
            t >= 100 -> {
                result.append("C")
                t -= 100
            }
            t >= 90 -> {
                result.append("XC")
                t -= 90
            }
            t >= 50 -> {
                result.append("L")
                t -= 50
            }
            t >= 40 -> {
                result.append("XL")
                t -= 40
            }
            t >= 10 -> {
                result.append("X")
                t -= 10
            }
            t == 9 -> {
                result.append("IX")
                t = 0
            }
            t >= 5 -> {
                result.append("V")
                t -= 5
            }
            t == 4 -> {
                result.append("IV")
                t = 0
            }
            t == 3 -> {
                result.append("III")
                t = 0
            }
            t == 2 -> {
                result.append("II")
                t = 0
            }
            t == 1 -> {
                result.append("I")
                t = 0
            }
            else -> t = 0
        }
    }
    return result.toString()
}

fun main() {
  val romanNumeral = intToRoman2(58)
  println(romanNumeral)
}
