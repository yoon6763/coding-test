package baekjoon.bronze.b4

fun main() {
    val (X, L, R) = readln().split(" ").map { it.toInt() }
    var res = 0
    var m = 100000

    for (n in L..R) {
        if (Math.abs(X - n) < m) {
            m = Math.abs(X - n)
            res = n
        }
    }

    println(res)
}
