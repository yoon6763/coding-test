package baekjoon.bronze.b3

fun main() {
    val (n, t) = readln().split(" ").map { it.toInt() }
    var ans = 1
    var flag = 1

    repeat(t - 1) {
        ans += flag
        if (ans == 1 || ans == 2 * n) flag = -flag
    }

    println(ans)
}