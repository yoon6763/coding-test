package baekjoon.bronze.b4

fun main() {
    readln()
    var tmp = 0L
    var sum = 0L

    readln().split(" ").map { it.toLong() }.forEach {
        tmp += if (it == 1L) 1 else -1
        sum += tmp
    }

    println(sum)
}