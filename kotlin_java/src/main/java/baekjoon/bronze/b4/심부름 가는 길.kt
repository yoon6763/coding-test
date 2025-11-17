package baekjoon.bronze.b4

fun main() {
    var time = 0
    repeat(4) {
        time += readln().toInt()
    }

    println("${time / 60}\n${time % 60}")
}