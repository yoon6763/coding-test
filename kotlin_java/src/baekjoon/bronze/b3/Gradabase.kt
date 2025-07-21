package baekjoon.bronze.b3

fun main() = repeat(readln().toInt()) {
    println("Case ${it + 1}:")
    repeat(readln().toInt()) {
        val g = readln().toInt() + 1
        if (g in 1..6) {
            println(g)
        }
    }
}
