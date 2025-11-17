package baekjoon.silver.s5

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    var result = Math.abs(a - b)
    repeat(readln().toInt()) {
        val k = readln().toInt()
        if (result > Math.abs(k - b)) {
            result = Math.abs(k - b) + 1
        }
    }
    println(result)
}
