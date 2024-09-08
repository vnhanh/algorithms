import java.io.File
import java.io.BufferedReader
import java.io.InputStream

 fun migratoryBirds(arr: Array<Int>): Int {
  val birds: MutableList<Array<Int>> = mutableListOf()

  quickSort(arr, 0, arr.lastIndex)
  for (i in arr.indices) {
      val sightedBird = arr[i]
      when {
          birds.isEmpty() || birds.last()[0] < sightedBird -> {
              birds.add(arrayOf(sightedBird, 1))
          }

          else -> {
              birds.last()[1]++
          }
      }
  }

  var seek = arrayOf(0, 0)
  for (element in birds) {
      if (seek[1] < element[1]) {
          seek = element
      }
  }

  return seek[1]
}

private fun quickSort(arr: Array<Int>, start: Int, end: Int) {
  if (start >= end) return
  var p = start
  var r = end
  while (p < r) {
    val pivotIndex = r
    val pivot = arr[pivotIndex]
    var i = p - 1
  
    for (j in p until r) {
      if (arr[j] < pivot) {
        i++
        swap(arr, i, j)
      }
    }
  
    val q = i+1
    swap(arr, q, pivotIndex)
    
    if (q - p - 1 <= end - (q+1)) {
      quickSort(arr, p, q-1)
      p = q+1
    } else {
      quickSort(arr, q+1, r)
      r = q-1
    }
  }
}

private fun swap(arr: Array<Int>, i: Int, j: Int) {
  val temp = arr[i]
  arr[i] = arr[j]
  arr[j] = temp
}

fun main(args: Array<String>) {
    val fileName = readLine()!!.trim()
    val inputFile = "$fileName.txt"

    val inputStream = File(inputFile).inputStream()    
    val lines = mutableListOf<String>()
    inputStream.bufferedReader().forEachLine { lines.add(it) }
    
    val arr = lines[1].trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    inputStream.close()

    val result = migratoryBirds(arr)

    println(result)
}
