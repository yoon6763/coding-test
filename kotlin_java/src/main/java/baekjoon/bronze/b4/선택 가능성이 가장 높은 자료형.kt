package baekjoon.bronze.b4

fun main() = print(
    when (readln().toLong()) {
        in Short.MIN_VALUE..Short.MAX_VALUE -> "short"
        in Int.MIN_VALUE..Int.MAX_VALUE -> "int"
        else -> "long long"
    }
)