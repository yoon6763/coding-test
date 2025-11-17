package baekjoon.bronze.b2

fun main() = repeat(readln().toInt()) {
    val line = readln().toCharArray().map { it.digitToInt() }.toIntArray()
    for (i in line.indices) {
        if (i % 2 == 0) {
            var num = line[i] * 2
            if (num > 9) num = num / 10 + num % 10
            line[i] = num
        }
    }
    println(if (line.sum() % 10 == 0) "T" else "F")
}