package baekjoon.bronze.b3

fun main() {
    readln();println(if (readln().split(" ").sumOf { it.toInt() } % 3 == 0) "yes" else "no")
}
