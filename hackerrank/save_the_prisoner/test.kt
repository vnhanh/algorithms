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

/*
 * Complete the 'saveThePrisoner' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n the number of prisoners
 *  2. INTEGER m the number of sweets
 *  3. INTEGER s the chair number to begin passing out sweets from
 */

fun saveThePrisoner(n: Int, m: Int, s: Int): Int {
    val balance = (s + m - 1) % n
    
    return when {
        balance == 0 -> n
        else -> balance
    }
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val first_multiple_input = readLine()!!.trimEnd().split(" ")

        val n = first_multiple_input[0].toInt()

        val m = first_multiple_input[1].toInt()

        val s = first_multiple_input[2].toInt()

        val result = saveThePrisoner(n, m, s)

        println(result)
    }
}
