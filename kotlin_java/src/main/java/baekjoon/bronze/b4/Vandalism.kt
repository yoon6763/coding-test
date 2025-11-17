package baekjoon.bronze.b4

fun main() {
    val input = readln()
    var idx = 0
    "UAPC".forEach { if (idx < input.length && input[idx] == it) idx++ else print(it) }
}
