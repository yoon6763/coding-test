package baekjoon.bronze.b3

fun main() {
    val (t, d, m) = readln().split(" ").map { it.toInt() }

    var flag = false
    var pre = 0

    repeat(m) {
        val n = readln().toInt()
        if (n - pre >= t) flag = true
        pre = n
    }

    if (d - pre >= t) flag = true
    println(if (flag) 'Y' else 'N')
}
