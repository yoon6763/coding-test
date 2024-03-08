package baekjoon.bronze.b2

fun main() {
    val map = hashMapOf(
        'B' to "v",
        'E' to "ye",
        'H' to "n",
        'P' to "r",
        'C' to "s",
        'Y' to "u",
        'X' to "h",
    )
    readln().forEach { print(map.getOrDefault(it, it.lowercase())) }
}