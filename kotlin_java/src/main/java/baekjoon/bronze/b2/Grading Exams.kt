package baekjoon.bronze.b2

fun main() {
    for (case in 1..readln().toInt()) {
        val n = readln().toInt()
        val a = readln()
        val b = readln()

        var ans = 0
        for (i in 0 until n) if (a[i] != b[i]) ans++
        println("Case $case: $ans")
    }
}
