package baekjoon.bronze.b4

fun main() = print(when (List(6) { readln() }.count { it == "W" }) {
    5, 6 -> "1"
    3, 4 -> "2"
    1, 2 -> "3"
    else -> "-1"
}
)