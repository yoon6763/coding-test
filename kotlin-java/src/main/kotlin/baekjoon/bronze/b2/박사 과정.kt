package baekjoon.bronze.b2

fun main() {
    repeat(readln().toInt()) {
        val str = readln()
        if ("=" in str) {
            println("skipped")
        } else {
            println(str.split("+").sumOf { it.toInt() })
        }
    }
}