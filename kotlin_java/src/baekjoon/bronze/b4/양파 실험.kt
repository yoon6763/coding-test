package baekjoon.bronze.b4

fun main() {
    val (n, a, b) = readln().split(" ").map { it.toInt() }

    var p = 1
    var q = 1

    repeat(n) {
        p += a
        q += b
        if (p < q) p = q.also { q = p }
        if (p == q) q -= 1
    }

    println("$p $q")
}
