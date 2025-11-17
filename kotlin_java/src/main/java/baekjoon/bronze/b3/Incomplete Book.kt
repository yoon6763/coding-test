package baekjoon.bronze.b3

fun main() {
    val (k, d) = readln().split(" ").map { it.toLong() }

    var day = 0L
    var ans = 0
    var acc = k

    while (day + acc <= d) {
        day += acc
        ans++
        acc *= 2
    }

    println(ans)
}
