package baekjoon.bronze.b1

import kotlin.random.Random

fun main() {
    val n = readln().toInt()

    while (true) {
        val ran = Random.nextInt(1, n + 1)
        println("? $ran")

        val answer = readln()
        if (answer == "Y") {
            println("! $ran")
            break
        }
    }
}