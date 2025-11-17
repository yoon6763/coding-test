package baekjoon.bronze.b3

fun main() {
    val k = readln().toInt()
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }
    val m = readln().toInt()
    val b = readln().split(" ").map { it.toInt() }

    var ans = 0

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (a[i] + k == b[j]) ans++
        }
    }

    println(ans)
}
