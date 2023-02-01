package baekjoon.silver.s2

fun main() {
    val nm = readLine()!!.split(" ")
    val treeCnt = nm[0].toLong()
    val need = nm[1].toLong()

    val trees = readLine()!!.split(" ").map { it.toLong() }.toLongArray()

    var min = 0L
    var max = trees.maxOrNull()!!
    var mid = (max / 2).toLong()

    while (min <= max) {
        mid = (min + max) / 2
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
        if(it > h) result += it - h
    }
    return result
}