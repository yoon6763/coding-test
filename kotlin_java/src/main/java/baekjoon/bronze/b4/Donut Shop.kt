package baekjoon.bronze.b4

fun main() {
    var ans = readln().toInt()

    repeat(readln().toInt()) {
        val op = readln()
        val q = readln().toInt()
        if (op == "+") ans += q else ans -= q
    }

    println(ans)
}