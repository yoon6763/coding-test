package baekjoon.bronze.b4

fun main() {
    var max = 0
    repeat(readln().toInt()) {
        val (a,b) = readln().split(" ").map(String::toInt)
        max = maxOf(max, a*b)
    }
    println(max)
}