package baekjoon.bronze.b3

fun main() {
    readln()
    var cnt = 0
    readln().split(" ").map { it.toInt() }.forEachIndexed { index, i -> if (index + 1 != i) cnt++ }
    println(cnt)
}