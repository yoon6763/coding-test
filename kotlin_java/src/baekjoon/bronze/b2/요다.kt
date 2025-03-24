package baekjoon.bronze.b2

fun main() {
    repeat(readln().toInt()) {
        val line = readln().split(" ")
        println(line.subList(2, line.size).joinToString(" ") + " " + line.subList(0, 2).joinToString(" "))
    }
}