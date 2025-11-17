package baekjoon.bronze.b2

fun main() {
    readln()
    val arr = readln().split(" ").map(String::toInt)
    val capacity = readln().toInt()

    var sum = 0L
    arr.forEach {
        sum += it / capacity
        if (it % capacity != 0) sum++
    }
    println(sum * capacity)
}