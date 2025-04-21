private fun generateParentheses(n: Int) : List<String> {
  val result = mutableListOf<String>()
  val currentStr = ""
  backtrack(currentStr, 0, 0, n, result)
  return result
}

private fun backtrack(currentStr: String, openCount: Int, closeCount: Int, n: Int, result: MutableList<String>) {
  if (currentStr.length == 2 * n) {
    result.add(currentStr)
    return
  }
  if (openCount < n) {
    backtrack(currentStr + "(", openCount + 1, closeCount, n, result)
  }

  if (closeCount < openCount) {
    backtrack(currentStr + ")", openCount, closeCount + 1, n, result)
  }
}

fun main() {
  val result = generateParentheses(4)
  println(result.joinToString("-"))
}
