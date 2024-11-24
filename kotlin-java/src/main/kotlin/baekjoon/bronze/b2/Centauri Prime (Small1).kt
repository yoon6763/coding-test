package baekjoon.bronze.b2

fun main() = repeat(readln().toInt()) {
    val s = readln()
    println("Case #${it + 1}: $s is ruled by ${when (s.last()) {
        'y' -> "nobody"
        in "aeiou" -> "a queen"
        else -> "a king"
    }}.")
}
