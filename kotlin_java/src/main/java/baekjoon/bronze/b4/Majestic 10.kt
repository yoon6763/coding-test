package baekjoon.bronze.b4

fun main() {
    repeat(readln().toInt()) {
        val arr = readln().split(" ").map { it.toInt() }
        println(arr.joinToString(" "))
        println(
            when (arr.count { it >= 10 }) {
                0 -> "zilch"
                1 -> "double"
                2 -> "double-double"
                3 -> "triple-double"
                else -> ""
            }
        )
        println()
    }
}