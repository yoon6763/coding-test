package baekjoon.bronze.b4

fun main() {
    val (height, target, grow) = readln().split(" ").map { it.toInt() }

    if (target <= height) println(0)
    else if ((target - height) % grow == 0) println((target - height) / grow)
    else println((target - height) / grow + 1)
}