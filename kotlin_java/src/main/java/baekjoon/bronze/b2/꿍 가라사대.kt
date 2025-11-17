package baekjoon.bronze.b2

fun main() {
    repeat(readln().toInt()) {
        val str = readln()
        if (str.startsWith("Simon says")) {
            println(str.substring(10))
        }
    }
}