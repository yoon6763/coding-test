package baekjoon.silver.s4

fun main(): Unit = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val map = mutableMapOf<Long, Int>()

    repeat(n) {
        val num = readLine().toLong()
        map[num] = map.getOrDefault(num, 0) + 1
    }

    var max = 0
    var maxNum = 0L

    map.forEach { (num, count) ->
        if (count > max) {
            max = count
            maxNum = num
        } else if (count == max && num < maxNum) {
            maxNum = num
        }
    }

    println(maxNum)
}