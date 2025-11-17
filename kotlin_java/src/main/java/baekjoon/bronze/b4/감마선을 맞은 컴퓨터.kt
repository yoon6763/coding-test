package baekjoon.bronze.b4

fun main() = print(when (mutableSetOf<String>().apply {
        repeat(15) { addAll(readln().split(" ")) }
        removeAll(listOf("r", "o", "y", "p")) }.toList()[0]) {
        "w" -> "chunbae"
        "b" -> "nabi"
        "g" -> "yeongcheol"
        else -> ""
    }
)