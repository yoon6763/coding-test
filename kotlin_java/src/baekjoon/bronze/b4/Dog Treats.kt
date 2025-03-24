package baekjoon.bronze.b4

fun main() {
    val (s, m, l) = Array(3) { readln().toInt() }
    println(if (s + m * 2 + l * 3 < 10) "sad" else "happy")
}