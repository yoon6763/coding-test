package baekjoon.bronze.b2

fun main() = repeat(readln().toInt()) {
    val b = readln().toInt()
    val input = readln().replace('O', '0').replace('I', '1')
    val content = StringBuilder()
    for (i in 0..<b) {
        content.append(input.substring(8 * i, 8 * (i + 1)).toInt(2).toChar())
    }
    println("Case #${it + 1}: $content")
}