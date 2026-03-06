package baekjoon.bronze.b3

fun main() {
    val c = readln().toDouble()
    val l = readln().toInt()

    var ans = 0.0

    repeat(l) {
        val (w, l) = readln().split(" ").map { it.toDouble() }
        ans += w * l
    }

    println("%.7f".format(ans * c))
}