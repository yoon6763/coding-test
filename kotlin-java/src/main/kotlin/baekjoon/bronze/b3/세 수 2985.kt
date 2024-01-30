package baekjoon.bronze.b3

fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }

    val operSimbol = listOf("+", "-", "*", "/")
    val oper = listOf(
        fun(a: Int, b: Int) = a + b,
        fun(a: Int, b: Int) = a - b,
        fun(a: Int, b: Int) = a * b,
        fun(a: Int, b: Int) = a / b
    )

    repeat(4) {
        if (oper[it](a, b) == c) {
            println("${a}${operSimbol[it]}${b}=${c}")
            return
        }
        if (a == oper[it](b, c)) {
            println("${a}=${b}${operSimbol[it]}${c}")
            return
        }
    }
}