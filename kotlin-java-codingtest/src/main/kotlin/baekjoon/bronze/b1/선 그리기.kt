package baekjoon.bronze.b1

fun main() {
    val line = Array(10001) { false }
    repeat(readln().toInt()) {
        val (s,e) = readln().split(" ").map(String::toInt)
        for (i in s until e) {
            line[i] = true
        }
    }

    println(line.count { it })
}