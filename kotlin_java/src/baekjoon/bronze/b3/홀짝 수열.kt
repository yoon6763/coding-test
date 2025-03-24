package baekjoon.bronze.b3

fun main() {
    var odd = 0
    var even = 0
    readln()
    readln().split(" ").map { it.toInt() }.forEach {
        if (it % 2 == 0) even++
        else odd++
    }
    if (odd == even + 1 || odd == even) println(1) else println(0)
}