package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    var ans = 0
    repeat(n) {
        val line = readln().split(" ").map { it.toInt() }
        val tric = line.slice(2..6).sortedDescending()
        ans = maxOf(ans, maxOf(line[0], line[1]) + tric[0] + tric[1])
    }

    println(ans)
}