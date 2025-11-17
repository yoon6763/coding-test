package baekjoon.bronze.b2

fun main() = repeat(readln().toInt()) {
    val vowels = "aeiou"
    val line = readln().lowercase().filter { it.isLetter() }
    println("${line.count { it !in vowels }} ${line.count { it in vowels }}")
}