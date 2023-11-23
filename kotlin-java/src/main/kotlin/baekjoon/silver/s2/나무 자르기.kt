package baekjoon.silver.s2

fun main() = with(System.`in`.bufferedReader()) {
    val nm = readLine().split(" ")
    val need = nm[1].toLong()

    val trees = readLine().split(" ").map { it.toLong() }.toLongArray()

    var min = 0L
    var max = trees.maxOrNull()!!

    while (min <= max) {
        val mid = (min + max) / 2
        val get = meter(trees, mid)

        if (get >= need) {
            min = mid + 1
        } else {
            max = mid - 1
        }
    }

    print(max)
}

fun meter(arr: LongArray, h: Long): Long {
    var result = 0L
    arr.forEach {
        if (it > h) result += it - h
    }
    return result
}