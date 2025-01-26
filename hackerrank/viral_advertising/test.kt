import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*
import kotlin.arrayOf

/*
 * Complete the 'viralAdvertising' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER n as parameter.
 */

fun viralAdvertising(n: Int): Int {
    if (n <= 0) return 0
    val board = Array(n) { Array(3) {0} }
    board[0] = arrayOf(5,2,2)
    for (i in 1..n-1) {
      val shared = board[i-1][1] * 3
      val liked = shared/2
      val cumulative = liked + board[i-1][2]
      board[i] = arrayOf(shared, liked, cumulative)
    }

    return board[n-1][2]
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val result = viralAdvertising(n)

    println(result)
}
