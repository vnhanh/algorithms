// substring runs very quickly and consume little memory, should use it
// StringBuilder.append() runs slowly. Can use index to get String[index] to compare and then get substring()
// String.length runs quickly 
// String[index] seems like not to run quickly, if comparing to String.substring()
class Solution {
    // takes 19ms with the Leetcode compiler 
    // time complexity: O (lgN x M)
    inline fun longestCommonPrefix1(strs: Array<String>): String {
        if (strs.size == 1) return strs[0]
        val longestIndex = strs.minOf { it.length } - 1
        if (longestIndex < 0) return ""

        var comparedChar = strs[0][0]
        val isSameFirstChar = strs.all { it[0] == comparedChar }
        if (!isSameFirstChar) return ""
        var lowBoundedIndex = 0
        // val matchedUpperBoundedIndex = longestIndex
        
        if (longestIndex == 1) {
            comparedChar = strs[0][1]
            return if (strs.all { it[1] == comparedChar }) {
                strs[0].substring(0,2)
            } else {
                strs[0].substring(0,1)
            }
        }

        var upperBoundedIndex = longestIndex
        var t = longestIndex/2

        while(true) {
            comparedChar = strs[0][t]
            if (strs.all{ it[t] == comparedChar }) {
                lowBoundedIndex = t
                t = when (t) {
                    upperBoundedIndex -> return strs[0].substring(0, upperBoundedIndex+1)
                    upperBoundedIndex - 1 -> upperBoundedIndex
                    else -> lowBoundedIndex + (upperBoundedIndex - lowBoundedIndex)/2
                }
            } else {
                if (t - lowBoundedIndex == 1) return strs[0].substring(0, t)
                // else: t - lowBoundedIndex > 1
                upperBoundedIndex = t
                t = lowBoundedIndex + (t - lowBoundedIndex)/2
            }
        }
        return ""
    }

    // time complexity: 5ms on leetcode
    inline fun longestCommonPrefix2(strs: Array<String>): String {
        if (strs.size == 1) return strs[0]

        // this block takes about 25ms -> too much
        // var longestIndex = strs.minOf { it.lastIndex }
        // if (longestIndex < 0) return ""

        var result = getFirstCommonString(strs[0], strs[1])
        for (i in 2 until strs.size) {
            result = getFirstCommonString(result, strs[i])
        }
        return result
    }

    inline fun getFirstCommonString(l: String, r: String) : String {
        val maxLength = min(l.length, r.length)
        var i = 0
        while (i < maxLength && l[i] == r[i]) i++
        return l.substring(0, i)
    }
}

// not mines - 0ms on leetcode
class BestSolution {
    fun longestCommonPrefix2(strs: Array<String>): String {

        var pref=strs[0]
        var prefixLength=pref.length
        var s:String
        for(i in 1 until strs.size){
            s=strs[i]
            if(s.length<prefixLength){
                prefixLength=s.length
                pref = pref.substring(0,prefixLength)
            }
            while(pref!=s.substring(0,prefixLength)){
                prefixLength--
                if(prefixLength==0){
                    return ""
                }
                pref = pref.substring(0,prefixLength)
            }

        }
        return pref
    }

    fun longestCommonPrefix3(strs: Array<String>): String {
        var result = strs[0]
        var tLength = result.length
        for (i in 1 until strs.size) {
            val str = strs[i]
            if (tLength > str.length) {
                tLength = str.length
                result = result.substring(0, tLength)
            }
            while (result != str.substring(0, tLength)) {
                tLength--
                result = result.substring(0, tLength)
            }
        }
        return result
    }
}

fun main() {
      val test = arrayOf("dog","racecar","car")
      println(Solution().longestCommonPrefix2(test))
}
