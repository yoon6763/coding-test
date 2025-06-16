package baekjoon.silver.s4.가로수

fun main() {
    val n = readln().toInt()
    val trees = IntArray(n) { readln().toInt() }
    var gcd = 0

    for (i in 0..<n - 1) gcd = gcd(trees[i + 1] - trees[i], gcd)

    println(((trees[n - 1] - trees[0]) / gcd + 1 - n))
}

fun gcd(a: Int, b: Int): Int {
    var a = a
    var b = b
    while (b != 0) {
        val r = a % b
        a = b
        b = r
    }
    return a
}
