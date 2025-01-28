fun intToRoman(num: Int): String {
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
  val romanNumeral = intToRoman(58)
  println(romanNumeral)
}
