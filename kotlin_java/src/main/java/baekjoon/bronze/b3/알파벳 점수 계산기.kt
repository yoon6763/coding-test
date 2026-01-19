package baekjoon.bronze.b3

fun main() {
    var sum = 0
    var pre = 'A'
    var buffer = 0

    readln().forEach {
        buffer = if (pre < it) buffer + 1 else 1
        sum += buffer
        pre = it
    }

    println(sum)
}