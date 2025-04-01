import java.util.Arrays


/**
 * Solution 1: 46ms. Time complexity: (O)n^3. I attempted to use check limitation of Int like below but it ran longer
 *  val s1 = nums[i] + nums[j]
    val s2 = nums[l] + nums[h]
    if (s1 > 0 && s2 > 0 && Int.MAX_VALUE - s1 < s2) {
        h--
        continue
    }
    if (s1 < 0 && s2 < 0 && Int.MIN_VALUE - s1 > s2) {
        l++
        continue
    }
 */
fun fourSum46(nums: IntArray, target: Int): List<List<Int>> {
    if (nums.size < 4) return listOf()
    val t = target.toLong()
    nums.sort()
    val res = mutableListOf<List<Int>>()
    var l: Int
    var h: Int
    for (i in 0..nums.lastIndex - 2) {
        if (i > 0 && nums[i] == nums[i-1]) continue
        for (j in (i+1)..nums.lastIndex-1) {
            if (j > i+1 && nums[j] == nums[j-1]) continue
            l = j+1
            h = nums.lastIndex
            while (l < h) {
                val s = (nums[i] + nums[j]).toLong() + (nums[l] + nums[h]).toLong()

                when {
                    s == t -> {
                        res.add(listOf(nums[i], nums[j], nums[l], nums[h]))
                        l++
                        h--
                        while (l < h && nums[l] == nums[l-1]) l++
                        while (l < h && nums[h] == nums[h+1]) h--
                    }
                    s < t -> {
                        l++
                    }
                    // s > target
                    else -> {
                        h--
                    }
                }
            }
        }
    }
    return res
}

/**
 * Solution 2: 59-76ms. I think it will run faster than the Solution 1 because its time complexity is (O)n^2-(O)n^3, but it's not
 */
fun fourSum76(nums: IntArray, target: Int): List<List<Int>> {
    if (nums.size < 4) return listOf()
    val res: MutableList<List<Int>> = mutableListOf<List<Int>>()
    nums.sort()
    val map = HashMap<Int,ArrayList<ArrayList<Int>>>(nums.size)

    for (i in 2..(nums.lastIndex - 1)) {
        for (j in (i+1)..(nums.lastIndex)) {
            val s = nums[i] + nums[j]
            val l2D: ArrayList<ArrayList<Int>>? = map[s]
            val last: ArrayList<Int>? = l2D?.lastOrNull()
            val newList: ArrayList<Int> = arrayListOf(i,j)
            if (last == null) {
                map[s] = ArrayList<ArrayList<Int>>().apply {
                    add(newList)
                }
                continue
            }
            l2D.add(newList)
            map[s] = l2D
        }
    }

    for (i in 0..nums.lastIndex-2) {
        if (i > 0 && nums[i] == nums[i-1]) continue
        for (j in (i+1)..nums.lastIndex-1) {
            if (j > i+1 && nums[j] == nums[j-1]) continue
            val s1 = nums[i] + nums[j]
            if (s1 < 0 && Int.MAX_VALUE + s1 < target) continue
            if (s1 > 0 && Int.MIN_VALUE + s1 > target) continue
            
            val s2 = target - s1
            val v = map[s2]
            if (v == null) continue
            for (l in v) {
                if (l[0] > j) {
                    val last: List<Int>? = res.lastOrNull()
                    if (last == null || last[0] != nums[i] || last[1] != nums[j] || last[2] != nums[l[0]] || last[3] != nums[l[1]]) {
                        res.add(arrayListOf(nums[i], nums[j], nums[l[0]], nums[l[1]]))
                    }
                }
            }
        }
    }

    return res
}

fun fourSum65(nums: IntArray, target: Int): List<List<Int>> {
    if (nums.size < 4) return listOf()
    val res: MutableList<List<Int>> = mutableListOf<List<Int>>()
    val map = HashMap<Long,ArrayList<Int>>(nums.size)
    val t = target.toLong()
    nums.sort()

    for (i in 2..(nums.lastIndex - 1)) {
        for (j in (i+1)..(nums.lastIndex)) {
            val s = (nums[i] + nums[j]).toLong()
            val l2D: ArrayList<Int>? = map[s]
            if (l2D == null) {
                map[s] = arrayListOf(i, j)
                continue
            }
            l2D.add(i)
            l2D.add(j)
            map[s] = l2D
        }
    }

    for (i in 0..nums.lastIndex-2) {
        if (i > 0 && nums[i] == nums[i-1]) continue
        for (j in (i+1)..nums.lastIndex-1) {
            if (j > i+1 && nums[j] == nums[j-1]) continue
            val s1 = nums[i] + nums[j]
            // if (s1 < 0 && Int.MAX_VALUE + s1 < target) continue
            // if (s1 > 0 && Int.MIN_VALUE + s1 > target) continue
            
            val s2 = t - s1
            if (s2 < Int.MIN_VALUE || s2 > Int.MAX_VALUE) continue
            val v = map[s2]
            if (v == null) continue
            var last: List<Int>? = null
            for (k in 0..(v.lastIndex-1) step 2) {
                if (v[k] > j) {
                    if (last == null || last[0] != nums[i] || last[1] != nums[j] || last[2] != nums[v[k]] || last[3] != nums[v[k+1]]) {
                        last = listOf(nums[i], nums[j], nums[v[k]], nums[v[k+1]])
                        res.add(last!!)
                    }
                }
            }
        }
    }

    return res
}

/**
 * Solution 3: belong to others. Time complexity is about 101ms, but leetcode said it's 18ms
 */
fun kSum(nums: IntArray, target: Long, start: Int, k: Int): List<MutableList<Int>> {
    val res: MutableList<MutableList<Int>> = ArrayList()

    if (start == nums.size) {
        println("start $start == nums.size")
        return res
    }

    val average = target / k
    println("average $average - k $k")

    if (nums[start] > average || average > nums[nums.size - 1]) {
        println("average $average out of target")
        return res
    }

    if (k == 2) return twoSum(nums, target, start)

    for (i in start until nums.size) {
        if (i == start || nums[i - 1] != nums[i]) {
            println("i $i - start $start - k-1 ${k-1}")
            for (subset in kSum(
                nums,
                target - nums[i],
                i + 1,
                k - 1
            )) {
                res.add(ArrayList(Arrays.asList(nums[i])))
                res[res.size - 1].addAll(subset)
            }
        }
    }

    return res
}

fun twoSum(nums: IntArray, target: Long, start: Int): List<MutableList<Int>> {
    val res: MutableList<MutableList<Int>> = ArrayList()
    var lo = start
    var hi = nums.size - 1

    while (lo < hi) {
        val currSum = nums[lo] + nums[hi]
        if (currSum < target || (lo > start && nums[lo] == nums[lo - 1])) {
            ++lo
        } else if (currSum > target ||
            (hi < nums.size - 1 && nums[hi] == nums[hi + 1])
        ) {
            --hi
        } else {
            res.add(Arrays.asList(nums[lo++], nums[hi--]))
        }
    }

    return res
}

fun fourSum(nums: IntArray, target: Int): List<MutableList<Int>> {
    nums.sort()
    return kSum(nums, target.toLong(), 0, 4)
}

fun main() {
    val input = intArrayOf(-3,-2,-1,0,0,1,2,3)
    println(fourSum(input, 0).joinToString("-"))
}
