package baekjoon.bronze.b2

fun main() {
    val n = readln().toInt()
    val photos = List(n) { readln().split(" ").map { it.toInt() } }
    var ans = 0

    for (i in 1 until n) {
        val (t1, d1, t2, d2) = photos[i - 1] + photos[i]
        ans = maxOf(ans, (d2 - d1) / (t2 - t1))
    }

    println(ans)
}
