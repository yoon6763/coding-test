package baekjoon.silver.s5

fun main() {
    val curTime = readln().split(":").map { it.toInt() }
    val targetTime = readln().split(":").map { it.toInt() }

    val curMin = curTime[0] * 60 + curTime[1]
    val targetMin = targetTime[0] * 60 + targetTime[1]

    val diff = (targetMin - curMin + 1440) % 1440

    println(diff / 60 + diff % 60)
}
