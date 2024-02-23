package baekjoon.silver.s2

fun main() = with(System.`in`.bufferedReader()) {
    val (n, needWoodCapacity) = readLine().split(" ").map { it.toInt() }
    val woods = readLine().split(" ").map { it.toLong() }

    var left = 0L
    var right = woods.max()

    while (left < right) {
        val mid = (left + right) / 2
        val sum = woods.sumOf { maxOf(0, it - mid) }

        if (sum >= needWoodCapacity) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    val list = ArrayList<Int>().sorted().toIntArray()


    println(left - 1)
}