package baekjoon.bronze.b2

fun main() {
    val k = readln().split(" ").map { it.toInt() }[0] % 26
    val f = { a: Char, b: Char, c: Int -> ((a - b + c) % 26 + b.code).toChar() }
    readln().forEach {
        print(
            when {
                it.isUpperCase() -> f(it, 'A', k)
                it.isLowerCase() -> f(it, 'a', k)
                else -> it
            }
        )
    }
}