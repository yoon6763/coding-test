package baekjoon.bronze.b3

fun main() {
    while (true) {
        val (a, op, b) = readln().split(" ")
        if (a == "0" && b == "0") break
        val s = if (op == "W") a.toInt() - b.toInt() else a.toInt() + b.toInt()
        println(if (s < -200) "Not allowed" else s)
    }
}
