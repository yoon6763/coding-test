package baekjoon.bronze.b3

fun main() {
    val n = readln().trim().toInt()
    var ans = 0L

    repeat(n) {
        val row = readln().trim().split(Regex("\\s+")).map { it.toInt() }
        val mx = row.max()
        if (mx > 0) ans += mx
    }

    println(ans)
}