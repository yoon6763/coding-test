package baekjoon.bronze.b3

fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }
    val b = readln().split(" ").map { it.toInt() }

    var ans = 0

    for (i in 0 until n) {
        if (a[i] > b[i]) {
            ans += 3
        } else if (a[i] == b[i]) {
            ans += 1
        }
    }

    println(ans)
}
