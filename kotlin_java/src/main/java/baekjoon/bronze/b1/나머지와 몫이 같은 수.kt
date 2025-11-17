package baekjoon.bronze.b1

fun main() {
    val num = readln().toLong()
    var sum = 0L
    for (i in 0..<num) sum += (num + 1) * i
    println(sum)
}
