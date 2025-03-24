package baekjoon.bronze.b3


fun main() {
    val cur = readln().split(":").map { it.toInt() }
    val start = readln().split(":").map { it.toInt() }

    val curTime = cur[0] * 3600 + cur[1] * 60 + cur[2]
    val startTime = start[0] * 3600 + start[1] * 60 + start[2]
    var diffTime = startTime - curTime
    if (diffTime <= 0) diffTime += 24 * 3600

    println("%02d:%02d:%02d".format(diffTime / 3600, (diffTime % 3600) / 60, diffTime % 60))
}
