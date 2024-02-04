package baekjoon.bronze.b3

fun main() {
    while (true) {
        val (a, b) = readln().split(" ").map(String::toInt).sorted()
        if (a == 0 && b == 0) break
        println(2 * a - b)
    }
}